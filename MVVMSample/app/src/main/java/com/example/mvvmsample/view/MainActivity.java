package com.example.mvvmsample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.mvvmsample.R;
import com.example.mvvmsample.data.models.Todo;
import com.example.mvvmsample.viewmodel.TodoListViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Todo> todos = new ArrayList<>();
    TodoListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(TodoListViewModel.class);
        viewModel.init();
        viewModel.getTodos().observe(this, response -> {
            todos.addAll(response);
            Log.e("Response", todos.size() + "");
        });
    }
}
