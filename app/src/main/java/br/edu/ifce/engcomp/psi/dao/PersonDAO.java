package br.edu.ifce.engcomp.psi.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.edu.ifce.engcomp.psi.model.Person;

/**
 * Created by FAMÍLIA on 28/03/2015.
 */
public class PersonDAO {

    private SQLiteDatabase db;

    public PersonDAO(Context context){
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void insert(Person person){
        ContentValues values = new ContentValues();
        values.put("name", person.getUsername());
        values.put("password", person.getPassword());
        values.put("email",person.getEmail());
        values.put("image",person.getImage());

        db.insert("person",null, values);
    }

    public Person getPerson(String email, String password){
        String sql = "SELECT * FROM person WHERE email =? AND password =?";
        String[] selectionArgs = new String[] {email, password };
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        cursor.moveToFirst();

        if(cursor.getCount()==0){
            return null;
        }

        Integer id = cursor.getInt(cursor.getColumnIndex("_id"));
        String name = cursor.getString(cursor.getColumnIndex("name"));
        String emailUser = cursor.getString(cursor.getColumnIndex("email"));
        String passwordUser = cursor.getString(cursor.getColumnIndex("password"));

        return new Person(id,name,emailUser,passwordUser);
    }

    public byte[] getImage(String email){
        String sql = "SELECT * FROM person WHERE email =?";
        String[] selectionArgs = new String[] {email};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        cursor.moveToFirst();

        if(cursor.getCount()==0){
            return null;
        }

        byte[] image = cursor.getBlob(cursor.getColumnIndex("image"));

        return image;
    }

}
