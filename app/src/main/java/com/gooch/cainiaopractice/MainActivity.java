package com.gooch.cainiaopractice;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.gooch.cainiaopractice.base.BaseActivity;
import com.gooch.cainiaopractice.contract.MainContract;
import com.gooch.cainiaopractice.databinding.ActivityMainBinding;
import com.gooch.cainiaopractice.presenter.MainPresenter;
import com.gooch.cainiaopractice.ui.adapter.MainPageFragmentAdapter;
import com.gooch.cainiaopractice.ui.fragment.PageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements MainContract.View, TabLayout.OnTabSelectedListener {

    private MainPresenter mPresenter;
    private String[] tabsTitle;

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
        initTabLayout();
        initViewPager();
    }

    private void initTabLayout() {
        tabsTitle = getResources().getStringArray(R.array.tabArray);
        for (int i = 0; i < tabsTitle.length; i++) {
            TabLayout.Tab tab = mBinding.tlMainTab.newTab();
            tab.setText(tabsTitle[i]);
        }
        mBinding.tlMainTab.setupWithViewPager(mBinding.vpContent);
        mBinding.tlMainTab.addOnTabSelectedListener(this);

    }

    private void initViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < tabsTitle.length; i++) {
            PageFragment pageFragment = new PageFragment();
            fragments.add(pageFragment);
        }
        MainPageFragmentAdapter adapter = new MainPageFragmentAdapter(getSupportFragmentManager(), fragments, tabsTitle);
        mBinding.vpContent.setAdapter(adapter);
        mBinding.vpContent.setOffscreenPageLimit(2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
