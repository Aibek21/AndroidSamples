package com.example.mvvmapplication.domain

import androidx.lifecycle.LiveData
import com.example.mvvmapplication.data.model.Item
import com.example.mvvmapplication.data.repository.RepoListDataStore

class GetRepoListUseCase(val repoListRepository: RepoListRepository) {
    fun getRepoList(): LiveData<List<Item>> {
        return repoListRepository.loadData()
    }
}