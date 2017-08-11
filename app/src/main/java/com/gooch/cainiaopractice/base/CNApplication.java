package com.gooch.cainiaopractice.base;

import android.app.Application;

/**
 * <pre>
 * author : gooch
 * e-mail : zhaoguangchao@100tal.com
 * time   : 2017/8/8
 * desc   :
 * version: 1.0
 * </pre>
 */


public class CNApplication extends Application {
    private static CNApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static CNApplication getmContext() {
        return mContext;
    }
}
