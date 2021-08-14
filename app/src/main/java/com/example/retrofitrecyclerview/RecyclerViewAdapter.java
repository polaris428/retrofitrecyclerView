package com.example.retrofitrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Response;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    Response<Articles> data;
    public  RecyclerViewAdapter(Response<Articles> data){
        super();
        this.data=data;
    }
    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerViewAdapter.ViewHolder holder, int position) {

        holder.nameTextView.setText(data.body().articles.get(position).author.username);
        holder.titleTextView.setText(data.body().articles.get(position).title);
        holder.contentsTextView.setText(data.body().articles.get(position).body);
        holder.dayTextView.setText(data.body().articles.get(position).updatedAt);
        Glide.with(holder.itemView).load(data.body().articles.get(position).author.image).into(holder.profileImageView);
    }

    @Override
    public int getItemCount() {
        return data.body().articlesCount;
    }

    class  ViewHolder extends  RecyclerView.ViewHolder{
        TextView nameTextView;
        TextView  titleTextView;
        TextView contentsTextView;
        ImageView profileImageView;
        TextView dayTextView;
        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            nameTextView=itemView.findViewById(R.id.nameTextView);
            titleTextView=itemView.findViewById(R.id.titleTextView);
            contentsTextView=itemView.findViewById(R.id.contentsTextView);
            profileImageView=itemView.findViewById(R.id.profileImageView);
            dayTextView=itemView.findViewById(R.id.dayTextView);

        }
    }
}
