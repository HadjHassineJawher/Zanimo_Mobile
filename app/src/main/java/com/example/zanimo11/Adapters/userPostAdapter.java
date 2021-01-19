package com.example.zanimo11.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;


import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zanimo11.Models.user;
import com.example.zanimo11.R;

import java.util.List;

public class userPostAdapter extends RecyclerView.Adapter<userPostAdapter.userPostViewHolder> {
    public static Context context;
    List<user> listeUser;



    public userPostAdapter(Context context, List<user> listeUser) {
        this.context = context;
        this.listeUser = listeUser;
    }

    @NonNull
    @Override
    public userPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_item, parent, false);
        userPostViewHolder userPostViewHolder = new userPostViewHolder(view);
        return userPostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull userPostViewHolder holder, int position) {

        user user = listeUser.get(position);
        holder.name.setText(user.getNom());
        Glide.with(context).load(user.getImageuser()).into(holder.imageUser);
      //  final   String id_user=user.get_id();
            postAapter postAapter= new postAapter(context,user.getPosts(),user);
            LinearLayoutManager  layoutManager=new LinearLayoutManager(getContext());
            holder.recyclerViewPost.setLayoutManager(layoutManager);
            holder.recyclerViewPost.setAdapter(postAapter);

    }

    private Context getContext() {
        return this.context;
    }

    @Override
    public int getItemCount() {
        return this.listeUser.size();
    }

    public static class userPostViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView imageUser;
        RecyclerView recyclerViewPost;

        public userPostViewHolder(View itemView) {
            super(itemView);
           name = (TextView) itemView.findViewById(R.id.name);
           imageUser = (ImageView) itemView.findViewById(R.id.imageUser);
           recyclerViewPost=(RecyclerView)itemView.findViewById(R.id.recyclerviewpost);
        }
    }
}
