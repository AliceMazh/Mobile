package com.example.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.myapplication.model.Question;

import java.util.List;

public class Addapter extends FragmentPagerAdapter {
    private List<Question> list;
    public static int current_item;

    public Addapter(FragmentManager mgr, List<Question> l) {
        super(mgr);
        this.list=l;
    }

    @Override
    public int getCount() {
        return (list.size());
    }

    @Override
    public Fragment getItem(int position) {
            current_item=position;
            return(PageFragment.newInstance(list.get(position)));
    }

    @Override
    public CharSequence getPageTitle(int position) {
            return (list.get(position).getQuest());
    }
}
