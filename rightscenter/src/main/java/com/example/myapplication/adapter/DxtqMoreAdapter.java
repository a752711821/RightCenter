package com.example.myapplication.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.myapplication.R;
import com.example.myapplication.entity.EnjoyGoodsEntity;
import com.example.myapplication.entity.UserRightInfoVO;
import com.example.myapplication.util.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

public class DxtqMoreAdapter extends RecyclerView.Adapter<DxtqMoreAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<EnjoyGoodsEntity.ObjBean> objBeanList;
    private LayoutInflater inflater;


    public DxtqMoreAdapter(Context context, ArrayList<EnjoyGoodsEntity.ObjBean> objBeanList) {
        this.context = context;
        this.objBeanList = objBeanList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_dxtq_more_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Glide.with(context)
                .load(objBeanList.get(position).getArImagePath())
                .asBitmap()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL) //设置缓存
                .into(new BitmapImageViewTarget(holder.imageIv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(DisplayUtil.dip2px(context, 5)); //设置圆角弧度
                        holder.imageIv.setImageDrawable(circularBitmapDrawable);
                    }
                });
        holder.titleTv.setText(objBeanList.get(position).getArName());
        holder.contentTv.setText(objBeanList.get(position).getArDescribe());
    }

    @Override
    public int getItemCount() {
        return objBeanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageIv;
        TextView titleTv;
        TextView contentTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageIv = itemView.findViewById(R.id.activity_dxtq_more_item_image_iv);
            titleTv = itemView.findViewById(R.id.activity_dxtq_more_item_title_tv);
            contentTv = itemView.findViewById(R.id.activity_dxtq_more_item_content_tv);
        }
    }
}
