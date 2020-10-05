package com.example.mvvmapplication.viewmodel

import androidx.lifecycle.LiveData
import com.example.mvvmapplication.data.model.Item
import com.example.mvvmapplication.domain.GetRepoListUseCase


class RepoListViewModel(val getRepoListUseCase: GetRepoListUseCase) : BaseViewModel() {
//    val repoListLive = MutableLiveData<List<Item>>()

    fun fetchRepoList(): LiveData<List<Item>> {
        return getRepoListUseCase.getRepoList()
//        dataLoading.value = true
//        getRepoListUseCase.getRepoList { isSuccess, response ->
//            dataLoading.value = false
//            if (isSuccess) {
//                repoListLive.value = response?.items
//                empty.value = false
//            } else {
//                empty.value = true
//            }
//        }
    }
}