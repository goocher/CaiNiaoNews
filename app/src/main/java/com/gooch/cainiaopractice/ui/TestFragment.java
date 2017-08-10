package com.gooch.cainiaopractice.ui;


import android.support.v4.app.Fragment;

import com.gooch.cainiaopractice.R;
import com.gooch.cainiaopractice.base.BaseFragment;
import com.gooch.cainiaopractice.contract.TestFragmentContract;
import com.gooch.cainiaopractice.databinding.FragmentTestBinding;
import com.gooch.cainiaopractice.presenter.TestFragmentPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends BaseFragment<FragmentTestBinding> implements TestFragmentContract.View {
    private TestFragmentPresenter mPresenter;

    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    protected void init() {
        mPresenter = new TestFragmentPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

}
