package com.example.networkingsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

            APIService service = retrofit.create(APIService.class);

            service.getTodos().enqueue(new Callback<List<Todo>>() {
                @Override
                public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                    Log.e("Response size: ", response.body().size() + "");
                }

                @Override
                public void onFailure(Call<List<Todo>> call, Throwable t) {
                    Log.e("Error", t.getMessage());
                }
            });


//            service.getTodoById(1).enqueue(new Callback<Todo>() {
//                @Override
//                public void onResponse(Call<Todo> call, Response<Todo> response) {
//                    Log.e("Todo: ", response.body().getTitle());
//                }
//
//                @Override
//                public void onFailure(Call<Todo> call, Throwable t) {
//
//                }
//            });

//            service.getTodosByUserId(2, false).enqueue(new Callback<List<Todo>>() {
//                @Override
//                public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
//                    Log.e("Response size: ", response.body().size() + "");
//                }
//
//                @Override
//                public void onFailure(Call<List<Todo>> call, Throwable t) {
//
//                }
//            });

            service.addTodo(2, "Todo Something", false).enqueue(new Callback<Todo>() {
                @Override
                public void onResponse(Call<Todo> call, Response<Todo> response) {
                    Log.e("Todo: ", response.body().getTitle());
                }

                @Override
                public void onFailure(Call<Todo> call, Throwable t) {

                }
            });


//            service.getTodosFromUrl("https://jsonplaceholder.typicode.com/todos/").enqueue(new Callback<List<Todo>>() {
//                @Override
//                public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
//                    Log.e("Response size: ", response.body().size() + "");
//                }
//
//                @Override
//                public void onFailure(Call<List<Todo>> call, Throwable t) {
//                    Log.e("Error", t.getMessage());
//                }
//            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        ImageView imageView = findViewById(R.id.image);

        Picasso.get()
                .load("https://unsplash.com/photos/5Oe8KFH5998/download")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .centerCrop()
                .resize(300, 300)
                .rotate(90)
                .into(imageView);

    }
}
