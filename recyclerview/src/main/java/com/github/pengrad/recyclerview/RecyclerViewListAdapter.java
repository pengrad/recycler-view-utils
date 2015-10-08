package com.github.pengrad.recyclerview;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * stas
 * 7/23/15
 */
public abstract class RecyclerViewListAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder<T>> {

    private ItemClickListener<T> itemClickListener;
    private List<T> data;

    public RecyclerViewListAdapter() {
        this(null);
    }

    public RecyclerViewListAdapter(@Nullable ItemClickListener<T> itemClickListener) {
        this.itemClickListener = itemClickListener;
        setDataImpl(null);
    }

    private void setDataImpl(@Nullable Collection<T> data) {
        if (data == null) {
            this.data = new ArrayList<>(0);
        } else {
            this.data = new ArrayList<>(data.size());
            this.data.addAll(data);
        }
    }

    public RecyclerViewListAdapter<T> setData(Collection<T> data) {
        setDataImpl(data);
        notifyDataSetChanged();
        return this;
    }

    public RecyclerViewListAdapter<T> add(T item) {
        data.add(item);
        notifyDataSetChanged();
        return this;
    }

    public RecyclerViewListAdapter<T> add(int index, T item) {
        data.add(index, item);
        notifyDataSetChanged();
        return this;
    }

    public RecyclerViewListAdapter<T> addAll(Collection<? extends T> items) {
        data.addAll(items);
        notifyDataSetChanged();
        return this;
    }

    public RecyclerViewListAdapter<T> addAll(T... items) {
        for (T item : items) {
            data.add(item);
        }
        notifyDataSetChanged();
        return this;
    }

    public void clear() {
        data.clear();
        notifyDataSetChanged();
    }

    public void remove(T item) {
        data.remove(item);
    }

    public void remove(int index) {
        data.remove(index);
    }

    public void remove(Collection<T> items) {
        data.remove(items);
    }

    public List<T> getAll() {
        return data;
    }

    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public abstract RecyclerViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerViewHolder<T> holder, int position) {
        holder.onBind(data.get(position), itemClickListener);
    }
}
