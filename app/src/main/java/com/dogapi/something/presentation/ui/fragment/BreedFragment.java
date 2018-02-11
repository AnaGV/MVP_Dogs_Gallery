package com.dogapi.something.presentation.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.dogapi.core.presentation.ui.adapter.OnItemClickListener;
import com.dogapi.core.presentation.ui.fragment.BaseStackFragment;
import com.dogapi.something.R;
import com.dogapi.something.databinding.FragmentBreedBinding;
import com.dogapi.something.di.component.DaggerAppComponent;
import com.dogapi.something.domain.model.Breed;
import com.dogapi.something.presentation.contract.BreedContract;
import com.dogapi.something.presentation.ui.adapter.BreedAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ana on 07-02-18.
 */

public class BreedFragment extends BaseStackFragment<FragmentBreedBinding> implements BreedContract.View{
    @Inject BreedAdapter adapter;
    @Inject BreedContract.Presenter presenter;

    @Override
    protected int getNavigationContainer() {
        return R.id.stackContainer;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_breed;
    }

    @Override
    protected void initView() {
        presenter.initialize(this);
        initializeAdapter();
        initializeRecyclerView();
    }

    @Override
    protected void injectDependencies() {
        DaggerAppComponent.builder().build().inject(this);
    }

    public void initializeAdapter() {
        adapter = new BreedAdapter();
    }

    private void initializeRecyclerView() {
        binder.list.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binder.list.setHasFixedSize(true);
        binder.list.setAdapter(adapter);
    }

    @Override
    public void setBreeds(final List<Breed> breeds) {
        adapter.setList(breeds);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new OnItemClickListener<Breed>() {
            @Override
            public void onItemClick(int adapterPosition, Breed item) {
                getBaseStackFragment().addFragmentToStack(DetailBreedFragment.newInstance(item.name));
            }
        });
    }

    @Override
    public void showProgress(boolean show) {
        binder.progressBar.setVisibility(show? View.VISIBLE:View.GONE);
    }

    @Override
    public void showMessage(String message) {}
}
