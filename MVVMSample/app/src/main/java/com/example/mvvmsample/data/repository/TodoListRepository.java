package com.example.mvvmsample.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmsample.data.models.Todo;
import com.example.mvvmsample.data.networking.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoListRepository {

    private static TodoListRepository repository;


    public static TodoListRepository getInstance(APIService service) {
        if (repository == null)
            repository = new TodoListRepository(service);

        return repository;
    }


    private APIService service;

    public TodoListRepository(APIService service) {
        this.service = service;
    }

    public MutableLiveData<List<Todo>> getTodos() {
        MutableLiveData<List<Todo>> liveData = new MutableLiveData<>();

        service.getTodos().enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                Log.e("Response size: ", response.body().size() + "");
                if (response.isSuccessful()) {
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });

        return liveData;
    }

}
