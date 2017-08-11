package com.gooch.cainiaopractice.contract;

import com.gooch.cainiaopractice.base.IBaseView;

/**
 * <pre>
 * author : gooch
 * e-mail : zhaoguangchao@100tal.com
 * time   : 2017/8/11
 * desc   :
 * version: 1.0
 * </pre>
 */


public interface PageFragmentContract {
    interface Model {
        void loadData();
    }

    interface View extends IBaseView {
    }

    interface Presenter {
        void loadData();
    }
}
