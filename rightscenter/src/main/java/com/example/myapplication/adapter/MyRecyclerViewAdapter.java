package com.example.myapplication.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.R;
import com.example.myapplication.entity.EnjoyGoodsEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/5/18/018.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<EnjoyGoodsEntity.ObjBean> mDatas;

    public MyRecyclerViewAdapter(Context context, List<EnjoyGoodsEntity.ObjBean> mDatas) {
        this.mContext = context;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.recyclerview_item, null);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mDatas.get(position).getArImagePath())
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .fitCenter()
                .into(holder.mItemIv);
        holder.mTitleTv.setText(mDatas.get(position).getArName());
        holder.mContentTv.setText(mDatas.get(position).getArDescribe());
        holder.mPriceDzTv.setText(mDatas.get(position).getSalePrice() + "");
        holder.mPriceYjTv.setText(mDatas.get(position).getSaleJfPrice() + "");
        holder.mPriceYjTv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView mItemIv;
        TextView mTitleTv;
        TextView mContentTv;
        TextView mPriceDzTv;
        TextView mPriceYjTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            mItemIv = itemView.findViewById(R.id.item_image_iv);
            mTitleTv = itemView.findViewById(R.id.item_title_tv);
            mContentTv = itemView.findViewById(R.id.item_content_tv);
            mPriceDzTv = itemView.findViewById(R.id.item_price_dz_tv);
            mPriceYjTv = itemView.findViewById(R.id.item_price_yj_tv);

        }
    }
}
