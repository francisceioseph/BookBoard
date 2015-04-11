package br.edu.ifce.engcomp.psi.bookboard;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.Toast;
import android.util.Log;

/**
 * Created by FAMÍLIA on 06/04/2015.
 */
public class InfoBookFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle saveInstanceBundle) {
        super.onCreate(saveInstanceBundle);
        setContentView(R.layout.fragment_info_book_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);


        // Set the ViewPagerAdapter into ViewPager
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }

}
