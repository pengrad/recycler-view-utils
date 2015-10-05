package com.github.pengrad.recyclerview;

import android.view.View;

/**
 * stas
 * 7/23/15
 */
public interface ItemClickListener<T> {
    void onItemClick(T item, View view, int adapterPosition);
}
