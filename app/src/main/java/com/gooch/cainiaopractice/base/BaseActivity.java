package com.gooch.cainiaopractice.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * <pre>
 *     author : gooch
 *     e-mail : zhaoguangchao@100tal.com
 *     time   : 2017/08/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity implements IBaseView {
    protected T mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
//        StatusBarUtils.setTranslucent(this);
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        init();
    }


    protected abstract int getLayoutId();


    protected abstract void init();

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

//    public void switchContent(Fragment from, Fragment to) {
//        if (mContent != to) {
//            mContent = to;
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().setCustomAnimations(
//                    android.R.anim.fade_in, R.anim.slide_out);
//            if (!to.isAdded()) {    // 先判断是否被add过
//                transaction.hide(from).add(R.id.content_frame, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
//            } else {
//                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
//            }
//        }
//    }

//    public void switchContent(Fragment fragment) {
//        if (mContent != fragment) {
//            mContent = fragment;
//            getSupportFragmentManager().beginTransaction()
//                    .setCustomAnimations(android.R.anim.fade_in, R.anim.slide_out)
//                    .replace(R.id.content_frame, fragment) // 替换Fragment，实现切换
//                    .commit();
//        }
//    }


}
