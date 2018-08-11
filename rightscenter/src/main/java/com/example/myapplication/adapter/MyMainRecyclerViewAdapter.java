package com.example.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.R;
import com.example.myapplication.entity.NewEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/5/23/023.
 */

public class MyMainRecyclerViewAdapter extends RecyclerView.Adapter<MyMainRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<NewEntity> newEntityList;
    private LayoutInflater inflater;

    public MyMainRecyclerViewAdapter(Context context, List<NewEntity> newEntityList) {
        this.context = context;
        this.newEntityList = newEntityList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.my_main_re_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context)
                .load(newEntityList.get(position).getImageUrl())
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.imageView);
        holder.textView.setText(newEntityList.get(position).getName());
        holder.textView.setTextColor(Color.GRAY);
    }

    @Override
    public int getItemCount() {
        return newEntityList.size();
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
