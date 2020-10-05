package com.example.mvvmapplication.data.repository

import androidx.lifecycle.LiveData
import com.example.mvvmapplication.data.api.ApiService
import com.example.mvvmapplication.data.model.Item
import com.example.mvvmapplication.domain.RepoListRepository

class RepoListDataStore(apiService: ApiService) : RepoListRepository, BaseDataStore(apiService) {

    override fun loadData(): LiveData<List<Item>> {
        return fetchData { service.getRepo() }
    }
}