package com.daotrung.appfilm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daotrung.appfilm.R;
import com.daotrung.appfilm.model.AllCategory;
import com.daotrung.appfilm.model.CategoryItem;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>{
    Context context ;
    List<AllCategory> allCategories ;

    public MainRecyclerAdapter(Context context, List<AllCategory> allCategories) {
        this.context = context;
        this.allCategories = allCategories;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
       holder.categoryName.setText(allCategories.get(position).getCategoryTitle());
       setItemRecycler(holder.itemRecycler, allCategories.get(position).getCategoryItemList());
    }

    @Override
    public int getItemCount() {
        return allCategories.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        TextView categoryName ;
        RecyclerView itemRecycler ;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.item_category);
            itemRecycler = itemView.findViewById(R.id.item_recycler);
        }
    }

    private void setItemRecycler(RecyclerView recyclerView, List<CategoryItem> categoryItemList){
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(context,categoryItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(itemRecyclerAdapter);

    }
}
