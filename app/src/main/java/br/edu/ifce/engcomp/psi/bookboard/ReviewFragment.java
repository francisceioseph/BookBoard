package br.edu.ifce.engcomp.psi.bookboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import java.util.List;

import br.edu.ifce.engcomp.psi.dao.ReviewBookDAO;
import br.edu.ifce.engcomp.psi.model.Book;
import br.edu.ifce.engcomp.psi.model.Person;
import br.edu.ifce.engcomp.psi.model.ReviewBook;
import br.edu.ifce.engcomp.psi.util.UserSingleton;

/**
 * Created by FAMÍLIA on 05/04/2015.
 */
public class ReviewFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ReviewBook> reviewBookList;
    private Book book;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_review,container,false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_review);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        mRecyclerView.setLayoutManager(mLayoutManager);

        Bundle extras = getActivity().getIntent().getExtras();

        if (extras != null){
            book = (Book)extras.get("SELECTED_BOOK");

            // specify an adapter
            ReviewBookDAO reviewBookDAO = new ReviewBookDAO(getActivity().getApplicationContext());
            reviewBookList = reviewBookDAO.getReviewByIdBook(book.getIdBook());
            mAdapter = new ReviewAdapter(reviewBookList);
            mRecyclerView.setAdapter(mAdapter);
        }
        //Reposavel pelo button flutuante.
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.attachToRecyclerView(mRecyclerView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogReview(book);
            }
        });

        return(view);
    }


    public void dialogReview(Book book){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle("Livro : " + book.getTitle());
        alert.setMessage("Escreva sua resenha!");


        final EditText input = new EditText(getActivity());
        alert.setView(input);

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                ReviewBook reviewBook = new ReviewBook();
                Person person = new Person();
                person.setUsername(UserSingleton.getInstance().getName());
                reviewBook.setPerson(person);
                reviewBook.setDescription(input.getText().toString());
                Log.i("nOTA",input.getText().toString());
                //Update view
                if (!input.getText().toString().equals("")) {
                    reviewBookList.add(reviewBook);
                    mAdapter.notifyDataSetChanged();
                }
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {}
        });

        alert.show();

    }

}
