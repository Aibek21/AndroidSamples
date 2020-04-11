package com.example.mvvmsample.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmsample.data.models.Todo;
import com.example.mvvmsample.data.networking.RetrofitService;
import com.example.mvvmsample.data.repository.TodoListRepository;

import java.util.List;

public class TodoListViewModel extends ViewModel {

    private MutableLiveData<List<Todo>> liveData;
    private TodoListRepository repository;


    public void init() {
        if (liveData != null) {
            return;
        }

        repository = TodoListRepository.getInstance(RetrofitService.getService());
        liveData = repository.getTodos();
    }


    public MutableLiveData<List<Todo>> getTodos() {
        return liveData;
    }


}
