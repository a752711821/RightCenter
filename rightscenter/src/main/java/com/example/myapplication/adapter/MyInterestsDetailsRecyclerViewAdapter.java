package com.example.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.R;
import com.example.myapplication.entity.UserRightInfoVO;

import java.util.List;

/**
 * Created by Administrator on 2018/5/23/023.
 */

public class MyInterestsDetailsRecyclerViewAdapter extends RecyclerView.Adapter<MyInterestsDetailsRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<UserRightInfoVO.ListBean.DataBean> dataBeanList;
    private LayoutInflater inflater;
    private int mSelect = 0;   //选中项

    public MyInterestsDetailsRecyclerViewAdapter(Context context, List<UserRightInfoVO.ListBean.DataBean> dataBeanList) {
        this.context = context;
        this.dataBeanList = dataBeanList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.my_main_re_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    //点击选中图标
    public void changeSelected(int positon) {
        if (positon != mSelect) {
            mSelect = positon;
            notifyDataSetChanged();
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if (mSelect == position) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dip2px(context, 35), dip2px(context, 35));
            holder.imageView.setLayoutParams(params);
            Glide.with(context)
                    .load(dataBeanList.get(position).getRightInfoCheckImage())
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.imageView);
        } else {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dip2px(context, 27), dip2px(context, 27));
            holder.imageView.setLayoutParams(params);
            Glide.with(context)
                    .load(dataBeanList.get(position).getRightInfoUnCheckImage())
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.imageView);
        }

        holder.textView.setText(dataBeanList.get(position).getPermissionsName());
    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.test_main_re_iv);
            textView = itemView.findViewById(R.id.test_main_re_tv);
        }
    }
}
