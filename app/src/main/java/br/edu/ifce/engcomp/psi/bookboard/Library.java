package br.edu.ifce.engcomp.psi.bookboard;

import android.app.ListActivity;
import android.os.Bundle;

import br.edu.ifce.engcomp.psi.dao.BookDAO;

/**
 * Created by FAMÍLIA on 29/03/2015.
 */
public class Library extends ListActivity {

    public LibraryAdapter libraryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        BookDAO bookDAO = new BookDAO(this);

        libraryAdapter = new LibraryAdapter(this,bookDAO.getBookAll());

        setListAdapter(libraryAdapter);
    }


}
