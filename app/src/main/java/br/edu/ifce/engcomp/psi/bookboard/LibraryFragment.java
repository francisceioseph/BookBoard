package br.edu.ifce.engcomp.psi.bookboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import br.edu.ifce.engcomp.psi.dao.BookDAO;
import br.edu.ifce.engcomp.psi.model.Book;

/**
 * Created by francisco on 31/03/15.
 */
public class LibraryFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = (View) inflater.inflate(R.layout.list_view, container, false);
        final ListView booksListView = (ListView) rootView.findViewById(android.R.id.list);

        BookDAO bookDAO = new BookDAO(getActivity().getApplicationContext());

        booksListView.setAdapter(new LibraryAdapter(
                getActivity().getApplicationContext(),
                bookDAO.getBookAll()
        ));


        booksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = (Book)booksListView.getAdapter().getItem(position);
                //Toast.makeText(getActivity().getApplicationContext(),"Teste", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(),InfoBookActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

 }
