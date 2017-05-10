package com.example.yf.listcitydemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.yf.listcitydemo.R;
import com.example.yf.listcitydemo.adapter.base.BaseAdapter;
import com.example.yf.listcitydemo.activity.RecyclerItemClickListener;
import com.example.yf.listcitydemo.model.CityModel;
import com.example.yf.listcitydemo.holder.ItemViewHolder;

/**
 * Created by yf on 03/05/2017.
 * 城市列表具体的数据
 */

public class CityListAdapter extends BaseAdapter<CityModel, ItemViewHolder> {
    private RecyclerItemClickListener.OnItemClickListener onClickListener;

    public CityListAdapter(Context context) {
        super(context);
    }

    @Override
    protected ItemViewHolder createItemViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(parent, R.layout.list_city_name);
    }

    @Override
    protected void bindCustomViewHolder(final ItemViewHolder holder, final int position) {
        holder.mCityName.setText(data.get(position).getCityName());
        holder.mCityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onItemClick(holder.mCityName,position);
            }
        });
    }

    public void setOnClickListener(RecyclerItemClickListener.OnItemClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
