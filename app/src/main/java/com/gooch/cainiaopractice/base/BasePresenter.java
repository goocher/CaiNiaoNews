package com.gooch.cainiaopractice.base;

/**
 * <pre>
 *     author : gooch
 *     e-mail : zhaoguangchao@100tal.com
 *     time   : 2017/08/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class BasePresenter<T extends IBaseView> {
    protected T mView;

    public void attachView(T baseView) {
        mView = baseView;
    }

    public void detachView() {
        mView = null;
    }

    private boolean isViewAttached() {
        return mView != null;
    }

    public T getMvpView() {
        checkViewAttached();
        return mView;
    }

    private void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    private static class MvpViewNotAttachedException extends RuntimeException {
        private static final long serialVersionUID = 2443459480929610110L;

        MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
