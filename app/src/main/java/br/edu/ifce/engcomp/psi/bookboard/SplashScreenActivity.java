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

        Person person10 = new Person("Kamila Freire","ka@gmail.com","1234");
        Person person11 = new Person("Tammy","tammy@gmail.com","1234");
        Person person12 = new Person("Lucks","lucks@gmail.com","1234");
        Person person13 = new Person("Luana","luana@gmail.com","1234");
        Person person14 = new Person("Sergio Ricardo","sergio@gmail.com","1234");
        Person person15 = new Person("Guillherme","guilherme@gmail.com","1234");
        Person person16 = new Person("Lorena","lorena@gmail.com","1234");


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
        personDAO.insert(person10);
        personDAO.insert(person11);
        personDAO.insert(person12);
        personDAO.insert(person13);
        personDAO.insert(person14);
        personDAO.insert(person15);
        personDAO.insert(person16);
    }

}
