package br.ufpb.dcx.apps4society.educapimanager.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.dcx.apps4society.educapimanager.R;
import br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge.ChallengeFragment;
import br.ufpb.dcx.apps4society.educapimanager.view.ui.context.ContextFragment;

public class TabMenuAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private static TabMenuAdapter instance;


    public static TabMenuAdapter getInstance(@NonNull FragmentManager fm, int behavior){
        if(instance == null){
            instance = new TabMenuAdapter(fm, behavior);
            instance.add(new ContextFragment(),"Contextos");
            instance.add(new ChallengeFragment(),"Desafios");
        }

        return instance;
    }

    private TabMenuAdapter(@NonNull FragmentManager fm, int behavior) {
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
