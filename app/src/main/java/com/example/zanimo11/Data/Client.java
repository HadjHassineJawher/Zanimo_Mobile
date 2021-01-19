package com.example.zanimo11.Data;

import com.example.zanimo11.Models.posts;
import com.example.zanimo11.Models.user;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static final String BASE_URL = "http://192.168.1.15:3030/";
    private UserInterface userInterface;
    private static Client INSTANCE;

    public Client() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userInterface = retrofit.create(UserInterface.class);
    }


    public static Client getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new Client();
        }
        return INSTANCE;
    }

    public Call<List<user>> getAllPost() {
        return userInterface.getAllPost();
    }

    public Call<posts> getOnePost(String id_user, String id_post) {
        return userInterface.getOnePost(id_user, id_post);
    }

    public Call<user> login(user user) {
        return userInterface.login(user);
    }

    public Call<user> addUser(user user) {
        return userInterface.addUser(user);
    }

    public Call<posts> AddPost(String id_user,posts posts) {
        return userInterface.AddPost(id_user,posts);
    }
}


