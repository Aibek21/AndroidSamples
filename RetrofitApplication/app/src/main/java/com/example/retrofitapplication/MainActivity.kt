package com.example.retrofitapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    var list = mutableListOf<Todo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val apiService = retrofit.create(ApiService::class.java)


//        apiService.getTodos().enqueue(object : Callback<List<Todo>> {
//            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
//                Log.e("Error", t.message)
//            }
//
//            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
//                Log.e("Response size: ", response.body()!!.size.toString() + "")
//                list.addAll(response.body()!!)
//            }
//        })


//        apiService.getTodoById(1).enqueue(object : Callback<Todo> {
//            override fun onFailure(call: Call<Todo>, t: Throwable) {
//                Log.e("Error", t.message)
//            }
//
//            override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
//                Log.e("Todo title: ", response.body()!!.title + "")
//            }
//        })

//        apiService.getTodosByUserId(1, false).enqueue(object : Callback<List<Todo>> {
//            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
//                Log.e("Error", t.message)
//            }
//
//            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
//                Log.e("Response size: ", response.body()!!.size.toString() + "")
//            }
//        })


//        apiService.addTodo(2, "Do something", false).enqueue(object : Callback<Todo> {
//            override fun onFailure(call: Call<Todo>, t: Throwable) {
//                Log.e("Error", t.message)
//            }
//
//            override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
//                Log.e("Todo title: ", response.body()!!.title + "")
//            }
//        })


//        apiService.getTodosWithUrl("https://jsonplaceholder.typicode.com/todos/")
//            .enqueue(object : Callback<List<Todo>> {
//                override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
//                    Log.e("Error", t.message)
//                }
//
//                override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
//                    Log.e("Response size: ", response.body()!!.size.toString() + "")
//                    list.addAll(response.body()!!)
//                }
//            })


        Picasso.get()
            .load("https://www.planetware.com/wpimages/2020/02/france-in-pictures-beautiful-places-to-photograph-eiffel-tower.jpg")
            .resize(300, 300)
            .rotate(90f)
            .into(imageView)
    }
}