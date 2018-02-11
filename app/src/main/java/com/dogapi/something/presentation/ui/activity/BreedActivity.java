package com.dogapi.something.presentation.ui.activity;

import com.dogapi.core.presentation.ui.activity.BaseFragmentActivity;
import com.dogapi.something.R;
import com.dogapi.something.presentation.ui.fragment.BreedFragment;

/**
 * Created by ana on 07-02-18.
 */

public class BreedActivity extends BaseFragmentActivity {
    @Override
    protected void injectDependencies() {}

    @Override
    public void initView() {
        setFragment(new BreedFragment());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_breed;
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.fragmentContainer;
    }
}
