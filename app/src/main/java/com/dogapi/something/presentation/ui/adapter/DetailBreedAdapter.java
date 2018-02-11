package com.dogapi.something.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dogapi.core.presentation.ui.adapter.BaseListAdapter;
import com.dogapi.core.presentation.ui.adapter.holder.BaseViewHolder;
import com.dogapi.something.R;
import com.dogapi.something.databinding.ItemDetailBreedBinding;
import com.dogapi.something.domain.model.ImageBreedModel;

import java.util.List;

/**
 * Created by ana on 08-02-18.
 */

public class DetailBreedAdapter extends  BaseListAdapter<ImageBreedModel, DetailBreedAdapter.DetailBreedHolder> {
    @Override
    protected RecyclerView.ViewHolder createViewHolder(int viewType, View v) {
        return new DetailBreedHolder(v);
    }

    @Override
    protected int getLayoutIdByType(int viewType) {
        return R.layout.item_detail_breed;
    }

    public class DetailBreedHolder extends BaseViewHolder<ImageBreedModel, ItemDetailBreedBinding> {

        public DetailBreedHolder(View itemView) {super(itemView);}

        @Override
        public void bind(int position, ImageBreedModel item) {
            super.bind(position, item);
            if (item != null){
                Glide.with(getContext())
                        .load(item.image)
                        .apply(new RequestOptions().placeholder(R.mipmap.ic_launcher).centerCrop()
                                .error(R.mipmap.ic_launcher))
                        .into(binder.ivDetailImage);
            }
        }
    }

    @Override
    public void setList(List<ImageBreedModel> items) {
        super.setList(items);
    }
}
