package br.edu.ifce.engcomp.psi.bookboard;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.ifce.engcomp.psi.model.Book;

/**
 * Created by FAMÍLIA on 01/04/2015.
 */
public class InfoBookActivity extends Activity {
    private String titleBook,author;
    private Bitmap bitmap;
    TextView titleTextView,authorTextView, publisherTextView, volumeTextView, synopsysTextView;
    ImageView folderImageView;

    @Override
    protected void onCreate(Bundle saveInstanceBundle) {
        super.onCreate(saveInstanceBundle);
        setContentView(R.layout.info_book);

        titleTextView       = (TextView) findViewById(R.id.infoTextView1);
        authorTextView      = (TextView) findViewById(R.id.infoTextView2);
        publisherTextView   = (TextView) findViewById(R.id.publish);
        volumeTextView      = (TextView) findViewById(R.id.volume);
        synopsysTextView    = (TextView) findViewById(R.id.synopsisText);

        folderImageView     = (ImageView)findViewById(R.id.infoImageView1);

        Intent currentIntent = getIntent();
        Bundle extras = currentIntent.getExtras();

        if (extras != null) {
            Book book = (Book) extras.getSerializable("SELECTED_BOOK");

            titleTextView.setText(book.getTitle());
            authorTextView.setText(book.getTitle());
            publisherTextView.setText(book.getPublisher());
            volumeTextView.setText(String.format("Volume: %d", book.getVolume()));
            synopsysTextView.setText(" ");

            Bitmap bitmap = BitmapFactory.decodeByteArray(book.getImage(), 0, book.getImage().length);
            folderImageView.setImageBitmap(bitmap);
        }
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
