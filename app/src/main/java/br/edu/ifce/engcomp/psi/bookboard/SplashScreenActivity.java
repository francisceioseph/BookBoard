package br.edu.ifce.engcomp.psi.bookboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import br.edu.ifce.engcomp.psi.dao.PersonDAO;
import br.edu.ifce.engcomp.psi.model.Person;
import br.edu.ifce.engcomp.psi.util.BookForDB;


/**
 * Created by FAMÍLIA on 27/03/2015.
 */
public class SplashScreenActivity extends Activity implements Runnable{

    @Override
    protected void onCreate(Bundle saveInstanceBundle){
        super.onCreate(saveInstanceBundle);
        setContentView(R.layout.tela_abertura);

        //insertUserDB();
        //BookForDB.getBookForDB(getResources(), this);
        Handler splashScreenHandle = new Handler();
        splashScreenHandle.postDelayed(SplashScreenActivity.this,4000);
    }

    public void run(){
        startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
        finish();
    }

    public void insertUserDB(){
        PersonDAO personDAO = new PersonDAO(this);
        Person person = new Person("Gracyane Oliveira","gracyane@hotmail.com","1234");
        Person person1 = new Person("Francisco José","francisco@gmail.com","1234");

        personDAO.insert(person);
        personDAO.insert(person1);
    }

}
