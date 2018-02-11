package com.dogapi.core.presentation.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by ana on 22-10-17.
 */

public abstract class BaseActivity<BINDER extends ViewDataBinding> extends AppCompatActivity{
    protected BINDER binder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = DataBindingUtil.setContentView(this,getLayoutId());
        injectDependencies();
        bindViews();
        initView();
    }

    protected abstract void injectDependencies();

    protected abstract int getLayoutId();

    private void bindViews() {
        ButterKnife.bind(this);
    }

    public void initView() {}

    protected void startActivity(Class activityClass) {
        Intent i = new Intent(this, activityClass);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        unbindViews();
        super.onDestroy();
    }

    private void unbindViews() {
        if(binder!=null)
            binder.unbind();
    }

    public void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
