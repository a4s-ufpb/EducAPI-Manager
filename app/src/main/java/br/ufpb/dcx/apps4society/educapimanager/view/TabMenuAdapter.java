package br.ufpb.dcx.apps4society.educapimanager.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge.ChallengeFragment;
import br.ufpb.dcx.apps4society.educapimanager.view.ui.context.ContextFragment;


public class TabMenuAdapter extends FragmentPagerAdapter {

    private Integer size = 2;

    public TabMenuAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ContextFragment();
            case 1:
                return new ChallengeFragment();
            default:
                return new ContextFragment();
        }
    }

    @Override
    public int getCount() {
        return this.size;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Contextos";
            case 1:
                return "Desafios";
            default:
                return "Contextos";
        }
    }
}
