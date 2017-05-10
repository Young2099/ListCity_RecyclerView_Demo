package com.example.yf.listcitydemo.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.yf.listcitydemo.holder.BaseViewHolder;

/**
 * Created by yf on 03/05/2017.
 * 封装Adapter的基类（绑定ViewHolder）
 */

public abstract class AbsAdapter<M, VH extends BaseViewHolder> extends RecyclerView.Adapter<BaseViewHolder> {
    protected Context mContext;

    public AbsAdapter(Context context) {
        mContext = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createItemViewHolder(parent, viewType);
    }

    /**
     * 创建自定义的viewholder
     * @param parent
     * @param viewType
     * @return ViewHolder
     */
    protected abstract VH createItemViewHolder(ViewGroup parent, int viewType);

    /**
     *  绑定自定一的viewholder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        bindCustomViewHolder((VH) holder,position);
    }

    /**
     *
     * @param holder
     * @param position
     */
    protected abstract void bindCustomViewHolder(VH holder, int position);

    @Override
    public int getItemCount() {
        return 0;
    }
}
