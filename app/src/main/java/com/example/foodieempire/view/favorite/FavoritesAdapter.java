package com.example.foodieempire.view.favorite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodieempire.R;
import com.example.foodieempire.model.pojo.Meal;
import com.example.foodieempire.view.home.MealIDInterface;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {
    List<Meal> meals;
    MealIDInterface mealIDInterface;
    DeleteFavItem deleteFavItem;

    public FavoritesAdapter(List<Meal> meals, MealIDInterface mealIDInterface, DeleteFavItem deleteFavItem) {
        this.meals = meals;
        this.mealIDInterface = mealIDInterface;
        this.deleteFavItem = deleteFavItem;
    }

    @NonNull
    @Override
    public FavoritesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapter.ViewHolder holder, int position) {
        Meal meal = meals.get(position);
        holder.text_fav.setText(meal.getStrMeal());
        Glide.with(holder.itemView).load(meal.getStrMealThumb()).placeholder(R.drawable.favbg).fitCenter()
                .into(holder.circle_image_fav);
        holder.fav_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteFavItem.deleteFav(meal.getIdMeal());
            }
        });
        holder.fav_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mealIDInterface.getMailId(meal.getIdMeal());
            }
        });

    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView fav_card;
        ImageView fav_icon;
        CircleImageView circle_image_fav;
        TextView text_fav;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fav_card = itemView.findViewById(R.id.fav_card);
            fav_icon = itemView.findViewById(R.id.fav_icon);
            circle_image_fav = itemView.findViewById(R.id.circle_image_fav);
            text_fav = itemView.findViewById(R.id.text_fav);
        }
    }
}
