package com.example.yf.listcitydemo.adapter;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;

import com.example.yf.listcitydemo.R;
import com.example.yf.listcitydemo.adapter.base.BaseAdapter;
import com.example.yf.listcitydemo.activity.RecyclerItemClickListener;
import com.example.yf.listcitydemo.model.CityModel;
import com.example.yf.listcitydemo.holder.ItemViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yf on 03/05/2017.
 * 城市列表所在item里面在包括一个RecyclerView
 */

public class ItemAdapter extends BaseAdapter<CityModel, ItemViewHolder> {

    private RecyclerItemClickListener.OnItemClickListener onItemListener;
    private ArrayMap<String, ArrayList<CityModel>> map;
    private Context mContext;
    private String style;

    public ItemAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected ItemViewHolder createItemViewHolder(ViewGroup parent, int viewType) {
        ItemViewHolder viewHolder = new ItemViewHolder(parent, R.layout.item_city_layout);
        return viewHolder;
    }

    @Override
    protected void bindCustomViewHolder(ItemViewHolder holder, int position) {
        holder.mNameSort.setText(data.get(position).getNameScort());
        if (map.containsKey(data.get(position).getNameScort())) {
            CityListAdapter cityAdapter = new CityListAdapter(mContext);
            cityAdapter.setData(map.get(data.get(position).getNameScort()));
            cityAdapter.setOnClickListener(onItemListener);
            if(style.equals("grid")){
                holder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
                holder.mRecyclerView.setAdapter(cityAdapter);

            }
            if(style.equals("list")){
                holder.mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
                holder.mRecyclerView.setAdapter(cityAdapter);
            }
        }
    }


    @Override
    public void setData(List<CityModel> list) {
        data = list;
    }

    public void setCityName(ArrayMap<String, ArrayList<CityModel>> cityName) {
        this.map = cityName;
    }

    public void setOnItmeListener(RecyclerItemClickListener.OnItemClickListener clickListener) {
        this.onItemListener = clickListener;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
