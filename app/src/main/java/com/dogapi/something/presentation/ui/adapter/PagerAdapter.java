package com.dogapi.something.presentation.ui.adapter;

import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dogapi.something.R;
import com.dogapi.something.domain.model.ImageBreedModel;

/**
 * Created by ana on 09-02-18.
 */

public class PagerAdapter extends CardPagerAdapter<ImageBreedModel> {

    @Override
    public void bind(ImageBreedModel item, View view) {
        ImageView imageView = view.findViewById(R.id.ivDetailImage);
        Glide.with(view.getContext())
                .load(item.image)
                //.apply(RequestOptions.circleCropTransform())
                .apply(new RequestOptions().placeholder(R.mipmap.ic_launcher_foreground)
                        .centerCrop().error(R.mipmap.ic_launcher_foreground))
                .into(imageView);
    }

    @Override
    public View instantiateView(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_detail_breed, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        return view;
    }
}
