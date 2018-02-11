package com.dogapi.something.presentation.ui.fragment;

import android.view.View;

import com.dogapi.core.presentation.ui.fragment.BaseFragment;
import com.dogapi.something.R;
import com.dogapi.something.databinding.FragmentBreedDetailBinding;
import com.dogapi.something.di.component.DaggerDetailComponent;
import com.dogapi.something.domain.model.ImageBreedModel;
import com.dogapi.something.presentation.contract.DetailBreedContract;
import com.dogapi.something.presentation.ui.adapter.PagerAdapter;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.List;

import javax.inject.Inject;
/**
 * Created by ana on 08-02-18.
 */

public class DetailBreedFragment extends BaseFragment<FragmentBreedDetailBinding> implements DetailBreedContract.View {

    @Inject PagerAdapter pagerAdapter;
    @Inject DetailBreedContract.Presenter presenter;
    String name;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_breed_detail;
    }

    public static DetailBreedFragment newInstance(String name) {
        DetailBreedFragment fragment = new DetailBreedFragment();
        fragment.name = name;
        return fragment;
    }

    @Override
    protected void initView() {
        presenter.initialize(this);
        presenter.setAllImage(name);
        HorizontalInfiniteCycleViewPager infiniteCycleViewPager = binder.rvDetailBreed;
        infiniteCycleViewPager.setAdapter(pagerAdapter);
        infiniteCycleViewPager.setMediumScaled(true);
        infiniteCycleViewPager.setMaxPageScale(0.8F);
        infiniteCycleViewPager.setMinPageScale(0.5F);
        infiniteCycleViewPager.setCenterPageScaleOffset(30.0F);
        infiniteCycleViewPager.setMinPageScaleOffset(5.0F);
        infiniteCycleViewPager.notifyDataSetChanged();

    }

    @Override
    protected void injectDependencies() {
        DaggerDetailComponent.builder().build().inject(this);
    }

    @Override
    public void showProgress(boolean show) {
        binder.progressBarDetail.setVisibility(show? View.VISIBLE:View.GONE);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void setImage(List<ImageBreedModel> image) {
        pagerAdapter.addCardList(image);
        pagerAdapter.notifyDataSetChanged();
    }
}
