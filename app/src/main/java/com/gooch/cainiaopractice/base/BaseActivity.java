package com.gooch.cainiaopractice.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gooch.cainiaopractice.utils.StatusBarUtils;

/**
 * <pre>
 *     author : gooch
 *     e-mail : zhaoguangchao@100tal.com
 *     time   : 2017/08/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity implements IBaseView {
    protected T mBinding;
    private BasePresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        StatusBarUtils.setColor(this, getResources().getColor(android.R.color.holo_blue_light), 150);
        mPresenter = new BasePresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mBinding = DataBindingUtil.setContentView(this, layoutResID);
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError() {

    }

}
