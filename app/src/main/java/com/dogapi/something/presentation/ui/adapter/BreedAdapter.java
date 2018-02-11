package com.dogapi.something.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dogapi.core.presentation.ui.adapter.BaseListAdapter;
import com.dogapi.core.presentation.ui.adapter.holder.BaseViewHolder;
import com.dogapi.something.R;
import com.dogapi.something.databinding.ItemBreedBinding;
import com.dogapi.something.domain.model.Breed;

import java.util.List;

/**
 * Created by ana on 07-02-18.
 */

public class BreedAdapter extends BaseListAdapter <Breed, BreedAdapter.BreedHolder> {

    @Override
    protected RecyclerView.ViewHolder createViewHolder(int viewType, View v) {
        return new BreedHolder(v);
    }

    @Override
    protected int getLayoutIdByType(int viewType) {
        return R.layout.item_breed;
    }

    public class BreedHolder extends BaseViewHolder<Breed,ItemBreedBinding> {

        public BreedHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(int position, Breed item) {
            super.bind(position, item);
            if (item != null){
                binder.tvNameBreed.setText(item.name);
                Glide.with(getContext())
                        .load(item.image)
                        .apply(new RequestOptions().placeholder(R.mipmap.ic_launcher_foreground)
                                .centerCrop().error(R.mipmap.ic_launcher_foreground))
                        .into(binder.ivImageBreed);
            }
        }
    }

    @Override
    public void setList(List<Breed> items) {
        super.setList(items);
    }
}
