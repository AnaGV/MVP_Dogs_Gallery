package com.dogapi.core.presentation.ui.adapter;

public interface OnItemClickListener<T> {
    void onItemClick(int adapterPosition, T item);
}