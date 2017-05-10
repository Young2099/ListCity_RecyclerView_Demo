package com.example.yf.listcitydemo.holder;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yf.listcitydemo.R;


/**
 * Created by yf on 03/05/2017.
 *
 */

public class ItemViewHolder extends BaseViewHolder {
    public TextView mNameSort;
    public RecyclerView mRecyclerView;
    public TextView mCityName;

    public ItemViewHolder(ViewGroup parent, @LayoutRes int resId) {
        super(parent, resId);
        mNameSort = getView(R.id.header_tv);
        mRecyclerView = getView(R.id.city_recyclerview);
        mCityName = getView(R.id.tv_cityname);
    }

}
