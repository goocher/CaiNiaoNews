package com.gooch.cainiaopractice;

import com.gooch.cainiaopractice.base.BaseActivity;
import com.gooch.cainiaopractice.contract.MainContract;
import com.gooch.cainiaopractice.databinding.ActivityMainBinding;
import com.gooch.cainiaopractice.presenter.MainPresenter;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements MainContract.View {

    private MainPresenter mPresenter;

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

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
