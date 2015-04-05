package br.edu.ifce.engcomp.psi.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifce.engcomp.psi.model.Book;

/**
 * Created by FAMÍLIA on 25/03/2015.
 */
public class BookDAO {

    private SQLiteDatabase db;

    public BookDAO(Context context){
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void insert(Book book){
        ContentValues values = new ContentValues();
        values.put("title", book.getTitle());
        values.put("author", book.getAuthor());
        values.put("image",book.getImage());
        values.put("publisher",book.getPublisher());

        db.insert("book",null, values);
    }

    public List<Book> getBookAll(){
        List<Book> bookList = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from book;",null);

        if(cursor.moveToFirst()){

            do {
                Book book = new Book();
                book.setIdBook(cursor.getInt(0));
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));
                book.setPublisher(cursor.getString(3));
                book.setImage(cursor.getBlob(4));
                bookList.add(book);
            }while (cursor.moveToNext());
        }
        return bookList;
    }
}
