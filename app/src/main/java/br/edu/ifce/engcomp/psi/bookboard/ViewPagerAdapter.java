package br.edu.ifce.engcomp.psi.bookboard;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by FAMÍLIA on 07/04/2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    // Tab Titles
    private String tabtitles[] = new String[] { "Detalhes", "Resenhas"};
    Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
               return new InfoBookFragment();
            case 1:
                return new ReviewFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}
