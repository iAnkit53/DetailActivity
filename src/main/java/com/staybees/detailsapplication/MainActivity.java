package com.staybees.detailsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<DetailModel> detailModels = new ArrayList<>();
    private DetailAdapter detailAdapter;
    private RecyclerView detail_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detail_recyclerview=(RecyclerView)findViewById(R.id.detail_recyclerview);
        detail_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        getDetailResponse();
    }

    private void getDetailResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://manage.extremes.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<List<DetailModel>> call = requestInterface.getDetailJson();

        call.enqueue(new Callback<List<DetailModel>>() {
            @Override
            public void onResponse(Call<List<DetailModel>> call, Response<List<DetailModel>> response) {
                detailModels = new ArrayList<>(response.body());
                detailAdapter = new DetailAdapter(MainActivity.this, detailModels);
                detail_recyclerview.setAdapter(detailAdapter);
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<DetailModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}