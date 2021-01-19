package com.example.zanimo11.Controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zanimo11.Adapters.userPostAdapter;
import com.example.zanimo11.Data.Client;
import com.example.zanimo11.Models.user;
import com.example.zanimo11.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LostFragment extends Fragment {
    private RecyclerView recyclerViewUser;
    private RecyclerView.LayoutManager layoutManager;
    Client client;

    List<user> listu = new ArrayList<user>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        client= new Client();
        View v=inflater.inflate(R.layout.lost_fragment,container,false);

        client.getAllPost().enqueue(new Callback<List<user>>() {
            @Override
            public void onResponse(Call<List<user>> call, Response<List<user>> response) {
                listu = response.body();
                recyclerViewUser = v.findViewById(R.id.recyclerViewLost);
                layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                recyclerViewUser.setLayoutManager(layoutManager);
                userPostAdapter adapter = new userPostAdapter(getContext(), listu);
                recyclerViewUser.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<user>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        return v ;
    }
}
