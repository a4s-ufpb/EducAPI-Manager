package br.ufpb.dcx.apps4society.educapimanager.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabMenuAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    public TabMenuAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    public void add(Fragment fragment, String tableTitle){
        this.fragments.add(fragment);
        this.titles.add(tableTitle);
    }

    @Override
    public CharSequence getPageTitle(int position){
        return this.titles.get(position);
    }
}
