package br.edu.ifce.engcomp.psi.bookboard;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.ifce.engcomp.psi.model.Book;

/**
 * Created by FAMÍLIA on 01/04/2015.
 */
public class InfoBookActivity extends ActionBarActivity {
    private String titleBook,author;
    private Bitmap bitmap;
    TextView titleTextView,authorTextView, publisherTextView, pageTextView, synopsysTextView;
    ImageView folderImageView;

    @Override
    protected void onCreate(Bundle saveInstanceBundle) {
        super.onCreate(saveInstanceBundle);
        setContentView(R.layout.info_book);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        

        titleTextView       = (TextView) findViewById(R.id.infoTextView1);
        authorTextView      = (TextView) findViewById(R.id.infoTextView2);
        publisherTextView   = (TextView) findViewById(R.id.publish);
        pageTextView        = (TextView) findViewById(R.id.pagina);
        synopsysTextView    = (TextView) findViewById(R.id.synopsisText);

        folderImageView     = (ImageView)findViewById(R.id.infoImageView1);

        Intent currentIntent = getIntent();
        Bundle extras = currentIntent.getExtras();

        if (extras != null) {
            Book book = (Book) extras.getSerializable("SELECTED_BOOK");

            titleTextView.setText(book.getTitle());
            authorTextView.setText(book.getAuthor());
            publisherTextView.setText("Ed. " + book.getPublisher());
            String numPage = String.valueOf(book.getNumberPage()) + " páginas";
            pageTextView.setText(numPage);
            //pageTextView.setText(String.format("%d", book.getNumberPage()+" páginas"));
            synopsysTextView.setText(book.getSynopsis());

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
