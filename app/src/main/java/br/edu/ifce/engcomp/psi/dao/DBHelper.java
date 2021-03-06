package br.edu.ifce.engcomp.psi.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by FAMÍLIA on 25/03/2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String NOME_DB = "bookboard";
    private static final int VERSAO_DB = 1;

    public DBHelper(Context context) {
        super(context, NOME_DB, null,VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table book(_id integer primary key autoincrement, title text not null, author text, publisher text, image blob, numberPage integer, synopsis text, year integer, rating double)");
        db.execSQL("create table person(_id integer primary key autoincrement, name text not null, password text not null, email text not null, image blob)");
        db.execSQL("create table review(_id integer primary key autoincrement, desc text, _idPerson integer, _idBook integer, foreign key(_idPerson) references person(_id),foreign key(_idBook) references book(_id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table book");
        db.execSQL("drop table person");
        db.execSQL("drop table review");
        onCreate(db);
    }
}
