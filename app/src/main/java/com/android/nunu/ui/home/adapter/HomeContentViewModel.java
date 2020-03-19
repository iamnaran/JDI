package com.android.nunu.ui.home.adapter;

import androidx.databinding.ObservableField;

import com.android.nunu.data.model.Home;

public class HomeContentViewModel {


    public final ObservableField<String> imageUrl;
    public final ObservableField<String> title;


    public final HomeContentListener mListener;
    private final Home.Datum mData;

    public HomeContentViewModel(HomeContentListener mListener, Home.Datum mData) {
        this.mListener = mListener;
        this.mData = mData;

        this.imageUrl = new ObservableField<>(mData.getImage());
        this.title = new ObservableField<>(mData.getName());
    }

    public interface HomeContentListener {

        void onItemClick(String blogUrl);
    }
}
