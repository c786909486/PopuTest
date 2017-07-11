package com.example.ckz.poputest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by CKZ on 2017/7/11.
 */

public class MyAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Integer> mData;

    public MyAdapter(Context mContext,List<Integer> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    private OnItemClickListener mItemClick;
    public void setOnItemClickListener(OnItemClickListener mItemClick){
        this.mItemClick = mItemClick;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_share,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        holder1.shareImg.setImageResource(mData.get(position));
        if (holder.itemView!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mItemClick.OnItemClickListener(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView shareImg;
        public MyViewHolder(View itemView) {
            super(itemView);
            shareImg = (ImageView) itemView.findViewById(R.id.share_img);
        }
    }

    public interface OnItemClickListener{
        void OnItemClickListener(View view,int position);
    }
}
