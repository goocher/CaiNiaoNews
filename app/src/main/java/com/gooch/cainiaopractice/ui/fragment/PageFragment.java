package com.gooch.cainiaopractice.ui.fragment;


import android.support.v4.app.Fragment;

import com.gooch.cainiaopractice.R;
import com.gooch.cainiaopractice.base.BaseFragment;
import com.gooch.cainiaopractice.contract.PageFragmentContract;
import com.gooch.cainiaopractice.databinding.FragmentPageBinding;
import com.gooch.cainiaopractice.presenter.PageFragmentPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends BaseFragment<FragmentPageBinding> implements PageFragmentContract.View {
    private PageFragmentPresenter mPresenter;

    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    protected void init() {
        mPresenter = new PageFragmentPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void loadData() {
        super.loadData();
        mPresenter.loadData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_page;
    }

    @Override
    public void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
