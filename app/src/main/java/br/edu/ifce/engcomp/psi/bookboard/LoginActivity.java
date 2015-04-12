package br.edu.ifce.engcomp.psi.bookboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifce.engcomp.psi.dao.PersonDAO;
import br.edu.ifce.engcomp.psi.model.Person;
import br.edu.ifce.engcomp.psi.util.UserSingleton;

/**
 * Created by FAMÍLIA on 28/03/2015.
 */
public class LoginActivity extends Activity{

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

                Person person = personDAO.getPerson(login.getText().toString(),password.getText().toString());

                UserSingleton.getInstance().setName(person.getUsername());
                UserSingleton.getInstance().setUserName(person.getEmail());

                String strlogin = login.getText().toString();
                String strsenha = password.getText().toString();

                //if (loginRight.equalsIgnoreCase(strlogin)&&senhaRight.equalsIgnoreCase(strsenha)){
                if (person!=null){
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

}
