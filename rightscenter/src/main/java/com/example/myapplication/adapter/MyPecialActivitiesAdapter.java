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
import com.example.myapplication.entity.PecialActivitiesEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/5/18/018.
 */

public class MyPecialActivitiesAdapter extends RecyclerView.Adapter<MyPecialActivitiesAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<PecialActivitiesEntity.ActivitysBean> mDatas;

    public MyPecialActivitiesAdapter(Context context, List<PecialActivitiesEntity.ActivitysBean> mDatas) {
        this.mContext = context;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.activity_pecial_activities_item, null);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mDatas.get(position).getAct_pic())
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
                .into(holder.mItemIv);
        holder.mTitleTv.setText(mDatas.get(position).getAct_title());
        holder.mContentTv.setText(mDatas.get(position).getAct_name());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView mItemIv;
        TextView mTitleTv;
        TextView mContentTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            mItemIv = itemView.findViewById(R.id.activity_pecial_activities_item_iv);
            mTitleTv = itemView.findViewById(R.id.activity_pecial_activities_item_title_tv);
            mContentTv = itemView.findViewById(R.id.activity_pecial_activities_item_content_tv);

        }
    }
}
