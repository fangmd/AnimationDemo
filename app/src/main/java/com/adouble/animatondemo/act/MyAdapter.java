package com.adouble.animatondemo.act;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.adouble.animatondemo.R;
import com.adouble.animatondemo.act.bean.RequestResult;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by double on 16-7-10.
 * Project: AnimatonDemo
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<RequestResult.TngouBean> mDatas;
    private Context mContext;

    public MyAdapter() {
        mDatas = new ArrayList<>();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_img, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String string = "http://tnfs.tngou.net/image" + mDatas.get(position).getImg();
        ImageView view = holder.mImageView;
        Glide.with(mContext).load(string).into(view);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addAll(Collection<? extends RequestResult.TngouBean> tngouBeens) {
        if (tngouBeens != null) {
            mDatas.addAll(tngouBeens);
            notifyItemRangeInserted(mDatas.size() - 1, tngouBeens.size());
        }
    }

    public void clear() {
        mDatas.clear();
        notifyItemMoved(0, mDatas.size() - 1);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_img)
        ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
