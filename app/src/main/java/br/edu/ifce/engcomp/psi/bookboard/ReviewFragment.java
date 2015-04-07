package br.edu.ifce.engcomp.psi.bookboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by FAMÍLIA on 05/04/2015.
 */
public class ReviewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_review,container,false);
        TextView tv = (TextView) view.findViewById(R.id.review);
        tv.setText("Review Fragment em ação");

        return(view);
    }

}
