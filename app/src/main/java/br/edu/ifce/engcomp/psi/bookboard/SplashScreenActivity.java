package br.edu.ifce.engcomp.psi.bookboard;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.util.List;

import br.edu.ifce.engcomp.psi.dao.PersonDAO;
import br.edu.ifce.engcomp.psi.dao.ReviewBookDAO;
import br.edu.ifce.engcomp.psi.model.Person;
import br.edu.ifce.engcomp.psi.model.ReviewBook;
import br.edu.ifce.engcomp.psi.util.BookForDB;
import br.edu.ifce.engcomp.psi.util.ImageUtil;
import br.edu.ifce.engcomp.psi.util.ReviewForDB;


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
            //ReviewForDB.insertReviewBookDB(this);

        Handler splashScreenHandle = new Handler();
        splashScreenHandle.postDelayed(SplashScreenActivity.this,2000);
    }

    public void run(){
        startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
        finish();
    }

    public void insertUserDB(){
        PersonDAO personDAO = new PersonDAO(this);

        Person person = new Person("Gracyane Oliveira","gracyane@hotmail.com","1234");
        person.setImage(ImageUtil.getImage(getResources(), R.drawable.ic_launcher));

        Person person1 = new Person("Francisco José","francisco@gmail.com","1234");
        person1.setImage(ImageUtil.getImage(getResources(), R.drawable.franze));

        Person person2 = new Person("User","user@gmail.com","1234");
        person2.setImage(ImageUtil.getImage(getResources(), R.drawable.franze));

        Person person3 = new Person("João Nunes","joao@gmail.com","1234");

        Person person4 = new Person("Cintia Rodrigues","cintia@gmail.com","1234");

        Person person5 = new Person("Matheus Silva","matheus@gmail.com","1234");
        Person person6 = new Person("Henrie Junior","henrie@hotmail.com","1234");
        Person person7 = new Person("Helio Fernandes","helio@gmail.com","1234");
        Person person8 = new Person("Fred Eu","fredeu@gmail.com","1234");
        Person person9 = new Person("Eduardo Leite","edu@gmail.com","1234");


        personDAO.insert(person);
        personDAO.insert(person1);
        personDAO.insert(person2);
        personDAO.insert(person3);
        personDAO.insert(person4);
        personDAO.insert(person5);
        personDAO.insert(person6);
        personDAO.insert(person7);
        personDAO.insert(person8);
        personDAO.insert(person9);
    }

}
