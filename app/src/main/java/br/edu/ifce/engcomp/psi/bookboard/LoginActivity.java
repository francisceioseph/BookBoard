package br.edu.ifce.engcomp.psi.bookboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.Header;
import org.json.JSONObject;
import org.json.JSONException;

import br.edu.ifce.engcomp.psi.dao.PersonDAO;
import br.edu.ifce.engcomp.psi.model.Person;
import br.edu.ifce.engcomp.psi.util.UserSingleton;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;


/**
 * Created by FAMÍLIA on 28/03/2015.
 */
public class LoginActivity extends Activity{

    private Person person;

    @Override
    protected void onCreate(Bundle saveInstanceBundle){
        super.onCreate(saveInstanceBundle);
        setContentView(R.layout.login_layout);

        final EditText login = (EditText)findViewById(R.id.login);
        final EditText password = (EditText)findViewById(R.id.senha);

        Button enter = (Button)findViewById(R.id.btnEntrar);
        Button cancel = (Button)findViewById(R.id.btnCancel);

        final PersonDAO personDAO = new PersonDAO(this);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String loginRight = "user";
                //String senhaRight = "1234";

                person = personDAO.getPerson(login.getText().toString(),password.getText().toString());

                String strlogin = login.getText().toString();
                String strsenha = password.getText().toString();

                //teste de login por WS
                //loginUser(strlogin, strsenha);

                //if (loginRight.equalsIgnoreCase(strlogin)&&senhaRight.equalsIgnoreCase(strsenha)){
                if (person!=null){
                    UserSingleton.getInstance().setId(person.getIdUser());
                    UserSingleton.getInstance().setName(person.getUsername());
                    UserSingleton.getInstance().setUserName(person.getEmail());
                    initializeScreenMain();
                    Toast.makeText(getApplicationContext(),"Seja bem vindo!",Toast.LENGTH_LONG ).show();
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Senha ou usuário incorretos!",Toast.LENGTH_LONG ).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initializeScreenMain(){
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void loginUser(String email, String password){

        RequestParams params = new RequestParams();

        params.put("email", email);
        params.put("password", password);
        invokeWS(params);
    }

    public void invokeWS(RequestParams params){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://bookws-oliv.rhcloud.com/bookws/login/dologin", params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                try {
                    JSONObject jsonObject = new JSONObject(new String(responseBody, "UTF-8"));

                    if(jsonObject.getBoolean("status")){
                        Log.i("RESPOSTA", String.valueOf(jsonObject.getBoolean("status")));
                        UserSingleton.getInstance().setId(person.getIdUser());
                        UserSingleton.getInstance().setName(person.getUsername());
                        UserSingleton.getInstance().setUserName(person.getEmail());
                        initializeScreenMain();
                        Toast.makeText(getApplicationContext(),"Seja bem vindo!",Toast.LENGTH_LONG ).show();
                        finish();
                    }else{
                        Log.i("RESPOSTA", "else");
                        Toast.makeText(getApplicationContext(),"Senha ou usuário incorretos!",Toast.LENGTH_LONG ).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    String str = new String(responseBody, "UTF-8");

                    Log.i("RESPOSTA", String.valueOf(statusCode));
                    Log.i("RESPOSTA", str);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.i("RESPOSTA", error.toString());
                Log.i("RESPOSTA", String.valueOf(statusCode));
            }
        });


    }

}
