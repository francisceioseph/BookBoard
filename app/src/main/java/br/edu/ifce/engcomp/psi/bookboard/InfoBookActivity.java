package br.edu.ifce.engcomp.psi.bookboard;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by FAMÍLIA on 01/04/2015.
 */
public class InfoBookActivity extends Activity {


    private String titleBook,author;
    private Bitmap bitmap;
    TextView titleTextView,authorTextView;
    ImageView folderImageView;

    @Override
    protected void onCreate(Bundle saveInstanceBundle) {
        super.onCreate(saveInstanceBundle);
        setContentView(R.layout.info_book);


        //titleTextView = (TextView)findViewById(R.id.infoTextView1);
        //titleTextView.setText(titleBook);

        //authorTextView = (TextView)findViewById(R.id.infoTextView2);
        //authorTextView.setText(author);

        //folderImageView = (ImageView)findViewById(R.id.infoImageView1);
        //folderImageView.setImageBitmap(bitmap);
    }


    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
