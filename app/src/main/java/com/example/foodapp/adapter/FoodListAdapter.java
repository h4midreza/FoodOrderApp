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
import com.example.foodapp.activity.DetailActivity;
import com.example.foodapp.domain.Foods;
import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.viewHolder> {
    ArrayList<Foods> items;
    Context context;

    public FoodListAdapter(ArrayList<Foods> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FoodListAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.viewholder_food_list, parent, false);
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.viewHolder holder, int position) {
        holder.titleText.setText(items.get(position).getTitle());
        holder.timeText.setText(items.get(position).getTimeValue() + " min");
        holder.priceText.setText("$" + items.get(position).getPrice());
        holder.starText.setText("" + items.get(position).getStar());

        Glide.with(context)
                .load(items.get(position).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(50))
                .into(holder.imgFoodList);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object", items.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView titleText, priceText, timeText, starText;
        ImageView imgFoodList;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            titleText = itemView.findViewById(R.id.titleTxt);
            priceText = itemView.findViewById(R.id.priceTxt);
            timeText = itemView.findViewById(R.id.timeTxt);
            starText = itemView.findViewById(R.id.rateTxt);
            imgFoodList = itemView.findViewById(R.id.imgFoodList);
        }
    }
}
