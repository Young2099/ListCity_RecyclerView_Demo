package com.example.yf.listcitydemo.adapter.base;

import android.content.Context;

import com.example.yf.listcitydemo.holder.BaseViewHolder;

import java.util.List;

/**
 * Created by yf on 03/05/2017.
 * 封装Adapter的基类（数据）
 */

public abstract class BaseAdapter<M, VH extends BaseViewHolder> extends AbsAdapter<M, VH> {

    protected List<M> data;

    public BaseAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<M> data) {
        if (data != null)
            this.data = data;
    }

    /**
     * 根据position获取数据
     *
     * @param position
     * @return
     */
    public M getItem(int position) {
        return data.get(position);
    }

    public M getItem(VH viewHolder) {
        return getItem(viewHolder.getAdapterPosition());
    }

}
