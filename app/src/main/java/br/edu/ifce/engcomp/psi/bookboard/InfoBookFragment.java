package br.edu.ifce.engcomp.psi.bookboard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.ifce.engcomp.psi.model.Book;

/**
 * Created by FAMÍLIA on 06/04/2015.
 */
public class InfoBookFragment extends Fragment {

    private String titleBook,author;
    private Bitmap bitmap;
    TextView titleTextView,authorTextView, publisherTextView, pageTextView, synopsysTextView;
    ImageView folderImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.info_book,container,false);

        titleTextView       = (TextView) view.findViewById(R.id.infoTextView1);
        authorTextView      = (TextView) view.findViewById(R.id.infoTextView2);
        publisherTextView   = (TextView) view.findViewById(R.id.publish);
        pageTextView        = (TextView) view.findViewById(R.id.pagina);
        synopsysTextView    = (TextView) view.findViewById(R.id.synopsisText);

        folderImageView     = (ImageView)view.findViewById(R.id.infoImageView1);

        Bundle extras = getActivity().getIntent().getExtras();

        if (extras != null){
            //Book book = (Book)getArguments().getSerializable("SELECTED_BOOK");
            Book book = (Book)extras.get("SELECTED_BOOK");

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

        return(view);
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