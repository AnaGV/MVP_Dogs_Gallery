package com.dogapi.something.presentation.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class CardPagerAdapter<T> extends PagerAdapter {

    public int MAX_ELEVATION_FACTOR = 3;

    protected List<CardView> mViews;
    protected List<T> mData;
    protected float mBaseElevation;

    public CardPagerAdapter() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardList(List<T> items) {

        mData.clear();
        mViews.clear();

        for(T item : items){
            mViews.add(null);
            mData.add(item);
        }

    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }


    public T getItemAt(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = instantiateView(container, position);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    public abstract void bind(T item, View view);
    public abstract View instantiateView(ViewGroup container, int position);


}
