package com.example.retrofitrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://conduit.productionready.io")
                .addConverterFactory(GsonConverterFactory.create()).client(client)
                .build();


        RealWorldService service=retrofit.create(RealWorldService.class);
        Call<Articles>call=service.getArticle();
        call.enqueue(new Callback<Articles>() {
            @Override
            public void onResponse(Call<Articles> call, Response<Articles> response) {
                if(response.isSuccessful()==true){
                    Articles data=response.body();
                    Article dataa2= response.body().articles.get(0);
                    Log.d("adsf",data.articlesCount+"");
                    Log.d("adsf",dataa2.createdAt);

                    RecyclerViewAdapter adapter=new RecyclerViewAdapter(response);
                    recyclerView.setAdapter(adapter);

                }


            }

            @Override
            public void onFailure(Call<Articles> call, Throwable t) {
                Log.d("adff",t+"");
            }
        });

    }
}