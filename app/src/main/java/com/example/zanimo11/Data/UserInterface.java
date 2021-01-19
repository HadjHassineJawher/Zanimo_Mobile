package com.example.zanimo11.Data;

import com.example.zanimo11.Models.posts;
import com.example.zanimo11.Models.user;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserInterface {
    @GET("Users/")
    public Call<List<user>> getAllPost();

    @GET("Users/OnePost/{id_user}/{id_post}")
    public Call<posts> getOnePost(@Path(value = "id_user", encoded = true) String id_user,
                                  @Path(value = "id_post", encoded = true) String id_post);
    @POST("Users/")
    Call<user> addUser(@Body user user);

    @POST("Users/AuthUser")
    Call<user> login(@Body user user);

    @POST("Users/AddPost/{id_user}")
     Call<posts> AddPost(@Path(value = "id_user", encoded = true) String id_user, @Body posts posts);

}

