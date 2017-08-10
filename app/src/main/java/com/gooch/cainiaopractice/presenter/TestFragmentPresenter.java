package com.gooch.cainiaopractice.presenter;

import com.gooch.cainiaopractice.base.BasePresenter;
import com.gooch.cainiaopractice.contract.TestFragmentContract;
import com.gooch.cainiaopractice.model.TestFragmentModel;

/**
 * <pre>
 *     author : gooch
 *     e-mail : zhaoguangchao@100tal.com
 *     time   : 2017/08/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class TestFragmentPresenter extends BasePresenter<TestFragmentContract.View> implements TestFragmentContract.Presenter {

    private TestFragmentModel mModel;

    @Override
    public void attachView(TestFragmentContract.View baseView) {
        super.attachView(baseView);
        mModel = new TestFragmentModel();
    }
}
