package br.edu.ifce.engcomp.psi.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifce.engcomp.psi.model.Person;
import br.edu.ifce.engcomp.psi.model.ReviewBook;

/**
 * Created by FAMÍLIA on 09/04/2015.
 */
public class ReviewBookDAO {

    private SQLiteDatabase db;

    public ReviewBookDAO(Context context){
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void insert(ReviewBook reviewBook){
        ContentValues values = new ContentValues();
        values.put("desc", reviewBook.getDescription());
        values.put("_idPerson", reviewBook.getPerson().getIdUser());
        values.put("_idBook",reviewBook.getBook().getIdBook());

        db.insert("review",null, values);
    }

    public List<ReviewBook> getReviewByIdBook(Integer idBook){

        List<ReviewBook> reviewBookList = new ArrayList<>();

        String sql = "select distinct person.name,review.desc from review join book join person where review._idBook=? and person._id=review._idPerson";
        String[] selectionArgs = new String[] {String.valueOf(idBook)};
        Cursor cursor = db.rawQuery(sql, selectionArgs);

        if(cursor.moveToFirst()){

            do {
                ReviewBook reviewBook = new ReviewBook();
                Person person = new Person();
                person.setUsername(cursor.getString(0));
                reviewBook.setPerson(person);
                reviewBook.setDescription(cursor.getString(1));

                reviewBookList.add(reviewBook);
            }while (cursor.moveToNext());
        }

       return reviewBookList;
    }

}
