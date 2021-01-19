package com.example.zanimo11.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zanimo11.Data.Client;
import com.example.zanimo11.Data.UserInterface;
import com.example.zanimo11.Models.posts;
import com.example.zanimo11.Models.user;
import com.example.zanimo11.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class postAapter extends RecyclerView.Adapter<postAapter.postViewHolder> {
    public static  Context context;
    List<posts> listPost;
    Dialog postDialog;
    user user;
    Client client;



    public postAapter(Context context,List<posts> listPost, user user) {
        this.context=context;
        this.listPost=listPost;
        this.user=user;
    }


    @NonNull
    @Override
    public postViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new postViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_post,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull postViewHolder holder, int position) {
        posts post = listPost.get(position);
        holder.description.setText(post.getDescription());
        Glide.with(context).load(post.getImage()).into(holder.ImagePost);
        client= new Client();
/*
        commentAdapter commentAdapter= new commentAdapter(getContext(),post.getComments());
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        holder.commentRecyclerView.setLayoutManager(layoutManager);
        holder.commentRecyclerView.setAdapter(commentAdapter);*/


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client.getOnePost(user.get_id(),post.get_id());
                postDialog=new Dialog(context);
                postDialog.setContentView(R.layout.activity_one_post);

                TextView name=(TextView)postDialog.findViewById(R.id.nameOnePost);
                ImageView imageuser=(ImageView)postDialog.findViewById(R.id.imageUserOnePost);
                ImageView imagePost=(ImageView) postDialog.findViewById(R.id.imagePostOnePost);
                TextView description=(TextView) postDialog.findViewById(R.id.descriptionOnePost);
                TextView comment=(TextView) postDialog.findViewById(R.id.commentTextOnePost);

                name.setText(user.getNom());
                Glide.with(context).load(user.getImageuser()).into(imageuser);
                Glide.with(context).load(post.getImage()).into(imagePost);
                description.setText(post.getDescription());
                comment.setText("");
                for (int i =0; i<post.getComments().size();i++){
                    comment.setText(comment.getText()+""+user.getNom()+":"+post.getComments().get(i).getComment()+"\n");
                    }
                postDialog.show();
            }
        });


    }
    private Context getContext() {
        return this.context;
    }
    @Override
    public int getItemCount() {
        return this.listPost.size() ;
    }

    public static class postViewHolder extends RecyclerView.ViewHolder {
        LinearLayout postlinearlayout;
        TextView description ;
        ImageView ImagePost;
        RecyclerView commentRecyclerView;


        public postViewHolder(View itemView) {
            super(itemView);
            postlinearlayout=(LinearLayout)itemView.findViewById(R.id.postLayout);
            description = (TextView) itemView.findViewById(R.id.description);
            ImagePost = (ImageView) itemView.findViewById(R.id.imagePost);
            commentRecyclerView=(RecyclerView) itemView.findViewById(R.id.commentRecyclerView);
        }
    }

}
