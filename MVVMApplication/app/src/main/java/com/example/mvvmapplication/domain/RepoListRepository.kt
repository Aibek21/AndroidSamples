package com.example.mvvmapplication.domain

import androidx.lifecycle.LiveData
import com.example.mvvmapplication.data.model.Item

interface RepoListRepository {
    fun loadData(): LiveData<List<Item>>
}