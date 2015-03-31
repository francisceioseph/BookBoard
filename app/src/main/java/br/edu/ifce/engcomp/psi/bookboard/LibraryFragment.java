package br.edu.ifce.engcomp.psi.bookboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import br.edu.ifce.engcomp.psi.dao.BookDAO;

/**
 * Created by francisco on 31/03/15.
 */
public class LibraryFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = (View) inflater.inflate(R.layout.list_view, container, false);
        ListView booksListView = (ListView) rootView.findViewById(android.R.id.list);

        BookDAO bookDAO = new BookDAO(getActivity().getApplicationContext());

        booksListView.setAdapter(new LibraryAdapter(
                getActivity().getApplicationContext(),
                bookDAO.getBookAll()
        ));

        return rootView;

    }
}
