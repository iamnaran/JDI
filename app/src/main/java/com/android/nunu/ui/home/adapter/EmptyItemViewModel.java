package com.android.nunu.ui.home.adapter;

public class EmptyItemViewModel {

    private EmptyItemViewModelListener mListener;

    public EmptyItemViewModel(EmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface EmptyItemViewModelListener {

        void onRetryClick();
    }
}
