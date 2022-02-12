package com.daotrung.appfilm.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daotrung.appfilm.R;
import com.daotrung.appfilm.model.CategoryItem;
import com.daotrung.appfilm.model.MovieDetail;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder>{
    Context context ;
    List<CategoryItem> categoryItemList ;

    public ItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.category_row_item,parent,false));
            }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context).load(categoryItemList.get(position).getImgUrl()).into(holder.itemImg);

        holder.itemImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetail.class);
                intent.putExtra("movieId",categoryItemList.get(position).getId());
                intent.putExtra("movieName",categoryItemList.get(position).getMovieName());
                intent.putExtra("movieImageUrl",categoryItemList.get(position).getImgUrl());
                intent.putExtra("movieFile",categoryItemList.get(position).getFileUrl());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImg ;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImg = itemView.findViewById(R.id.item_img);

        }
    }
}
