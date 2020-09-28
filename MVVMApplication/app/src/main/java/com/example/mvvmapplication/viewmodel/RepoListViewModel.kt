package com.example.mvvmapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmapplication.data.model.Item
import com.example.mvvmapplication.data.repository.RepoListRepository
import org.koin.experimental.property.inject


class RepoListViewModel(val repoListRepository: RepoListRepository) : BaseViewModel() {
    val repoListLive = MutableLiveData<List<Item>>()

    fun fetchRepoList() {
        dataLoading.value = true
        repoListRepository.getRepoList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                repoListLive.value = response?.items
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}