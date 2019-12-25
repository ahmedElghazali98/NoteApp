package com.ahmedElghazali.noteapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.categoryVh> {

    Context context;
    List<category> categoryList;


    public categoryAdapter(Context context, List<category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public categoryAdapter.categoryVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.grid_category , parent , false);
        categoryVh categoryvh = new categoryVh(view);

        return categoryvh;
    }

    @Override
    public void onBindViewHolder(@NonNull categoryVh holder, int position) {
        final String id = categoryList.get(position).getId();
        final String title = categoryList.get(position).getTitle();
        holder.setData(categoryList.get(position));

        holder.RelativeLayout_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,listNotes.class);
                intent.putExtra("id", id);
                intent.putExtra("Title", title);
                context.startActivity(intent);


            }
        });

    }



    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    class categoryVh extends RecyclerView.ViewHolder {
        TextView Grid_Tv;
        RelativeLayout RelativeLayout_grid ;


        public categoryVh(@NonNull View itemView) {
            super(itemView);
            Grid_Tv = itemView.findViewById(R.id.Grid_Tv);
            RelativeLayout_grid = itemView.findViewById(R.id.relativeLayout_grid);


        }

        public void setData(category c) {
            Grid_Tv.setText(c.getTitle());
        }
    }
}