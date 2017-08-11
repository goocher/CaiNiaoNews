package com.gooch.cainiaopractice.base;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * <pre>
 *     author : gooch
 *     e-mail : zhaoguangchao@100tal.com
 *     time   : 2017/08/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment implements IBaseView {
    protected Activity mActivity;
    protected T mBinding;
    private boolean mIsPrepared;
    private boolean mIsFirstLoad = true;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        init();
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mIsPrepared = true;
        if (getUserVisibleHint() && mIsFirstLoad && mIsPrepared) {
            mIsFirstLoad = false;
            loadData();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mIsPrepared = false;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }


    protected abstract void init();

    protected abstract int getLayoutId();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser && !mIsFirstLoad) {
            cancelLoadData();
        }
    }

    protected void cancelLoadData() {

    }


    protected void loadData() {

    }

    public void toast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
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
