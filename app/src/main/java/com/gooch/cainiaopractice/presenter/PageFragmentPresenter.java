package com.gooch.cainiaopractice.presenter;

import com.gooch.cainiaopractice.base.BasePresenter;
import com.gooch.cainiaopractice.contract.PageFragmentContract;
import com.gooch.cainiaopractice.model.PageFragmentModel;

/**
 * <pre>
 * author : gooch
 * e-mail : zhaoguangchao@100tal.com
 * time   : 2017/8/11
 * desc   :
 * version: 1.0
 * </pre>
 */


public class PageFragmentPresenter extends BasePresenter<PageFragmentContract.View> implements PageFragmentContract.Presenter {

    private PageFragmentModel mModel;

    @Override
    public void attachView(PageFragmentContract.View baseView) {
        super.attachView(baseView);
        mModel = new PageFragmentModel();
    }

    @Override
    public void loadData() {
        mModel.loadData();
    }
}
