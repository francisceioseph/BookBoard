package br.edu.ifce.engcomp.psi.bookboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edu.ifce.engcomp.psi.dao.ReviewBookDAO;
import br.edu.ifce.engcomp.psi.model.Book;

/**
 * Created by FAMÍLIA on 05/04/2015.
 */
public class ReviewFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_review,container,false);
        //TextView tv = (TextView) view.findViewById(R.id.review);
        //tv.setText("Review Fragment em ação");

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_review);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        mRecyclerView.setLayoutManager(mLayoutManager);

        Bundle extras = getActivity().getIntent().getExtras();

        if (extras != null){
            Book book = (Book)extras.get("SELECTED_BOOK");

            // specify an adapter (see also next example)
            ReviewBookDAO reviewBookDAO = new ReviewBookDAO(getActivity().getApplicationContext());
            mAdapter = new ReviewAdapter(reviewBookDAO.getReviewByIdBook(book.getIdBook()));
            mRecyclerView.setAdapter(mAdapter);
        }

        return(view);
    }

}
