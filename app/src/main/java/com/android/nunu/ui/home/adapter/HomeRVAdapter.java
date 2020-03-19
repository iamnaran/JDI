package com.android.nunu.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.nunu.data.model.Home;
import com.android.nunu.databinding.ItemEmptyViewBinding;
import com.android.nunu.databinding.ItemHomeContentViewBinding;
import com.android.nunu.ui.base.BaseViewHolder;

import java.util.List;

public class HomeRVAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private List<Home.Datum> homeList;

    private AdapterListener mListener;

    public HomeRVAdapter(List<Home.Datum> homeList) {
        this.homeList = homeList;
    }


    public interface AdapterListener {

        void onRetryClick();
    }

    public void addItems(List<Home.Datum> data) {
        homeList.addAll(data);
        notifyDataSetChanged();
    }

    public void clearItems() {
        homeList.clear();
    }

    public void setListener(AdapterListener listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemHomeContentViewBinding itemHomeContentViewBinding = ItemHomeContentViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new ItemContentViewHolder(itemHomeContentViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemEmptyViewBinding itemEmptyView = ItemEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new ItemEmptyViewHolder(itemEmptyView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);

    }


    @Override
    public int getItemViewType(int position) {
        if (homeList != null && !homeList.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (homeList != null && homeList.size() > 0) {
            return homeList.size();
        } else {
            return 1;
        }
    }

    private class ItemContentViewHolder extends BaseViewHolder {

        private ItemHomeContentViewBinding mBinding;

        public ItemContentViewHolder(ItemHomeContentViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {

        }
    }

    private class ItemEmptyViewHolder extends BaseViewHolder implements EmptyItemViewModel.EmptyItemViewModelListener{

        private ItemEmptyViewBinding mBinding;


        public ItemEmptyViewHolder(ItemEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {

        }

        @Override
        public void onRetryClick() {
            mListener.onRetryClick();

        }
    }
}
