package com.gooch.cainiaopractice.presenter;

import com.gooch.cainiaopractice.base.BasePresenter;
import com.gooch.cainiaopractice.contract.MainContract;
import com.gooch.cainiaopractice.model.MainModel;

/**
 * <pre>
 *     author : gooch
 *     e-mail : zhaoguangchao@100tal.com
 *     time   : 2017/08/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainModel mModel;

    @Override
    public void attachView(MainContract.View baseView) {
        super.attachView(baseView);
        mModel = new MainModel();
    }

}
