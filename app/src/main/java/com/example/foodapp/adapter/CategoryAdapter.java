package com.example.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.foodapp.R;
import com.example.foodapp.activity.FoodListActivity;
import com.example.foodapp.domain.Category;
import com.example.foodapp.domain.Foods;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewHolder> {
    ArrayList<Category> items;
    Context context;

    public CategoryAdapter(ArrayList<Category> item) {
        this.items = item;
    }

    @NonNull
    @Override
    public CategoryAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.viewholder_category, parent, false);
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getName());

        switch (position) {
            case 0: {
                holder.imageCat.setBackgroundResource(R.drawable.category0_bg);
                break;
            }
            case 1: {
                holder.imageCat.setBackgroundResource(R.drawable.category1_bg);
                break;
            }
            case 2: {
                holder.imageCat.setBackgroundResource(R.drawable.category2_bg);
                break;
            }
            case 3: {
                holder.imageCat.setBackgroundResource(R.drawable.category3_bg);
                break;
            }
            case 4: {
                holder.imageCat.setBackgroundResource(R.drawable.category4_bg);
                break;
            }
            case 5: {
                holder.imageCat.setBackgroundResource(R.drawable.category5_bg);
                break;
            }
            case 6: {
                holder.imageCat.setBackgroundResource(R.drawable.category6_bg);
                break;
            }
            case 7: {
                holder.imageCat.setBackgroundResource(R.drawable.category7_bg);
                break;
            }
        }
        int drawableResourceId = context.getResources().getIdentifier(
                items.get(position).getImagePath(), "drawable",
                holder.itemView.getContext().getPackageName()
        );

        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.imageCat);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, FoodListActivity.class);
            intent.putExtra("CategoryId", items.get(position).getId());
            intent.putExtra("CategoryName", items.get(position).getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt;
        ImageView imageCat;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.catNameTxt);
            imageCat = itemView.findViewById(R.id.imageCat);
        }
    }
}
