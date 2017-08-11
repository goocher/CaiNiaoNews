package com.gooch.cainiaopractice.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * <pre>
 * author : gooch
 * e-mail : zhaoguangchao@100tal.com
 * time   : 2017/8/11
 * desc   :
 * version: 1.0
 * </pre>
 */


public class MainPageFragmentAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragmentList;
    private String[] mTitles;

    public MainPageFragmentAdapter(FragmentManager fragmentManager, List<Fragment> fragments, String[] titles) {
        super(fragmentManager);
        fragmentList = fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList != null ? fragmentList.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
