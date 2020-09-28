package com.example.mvvmapplication.data.repository

import com.example.mvvmapplication.data.api.ApiClient
import com.example.mvvmapplication.data.api.ApiService
import com.example.mvvmapplication.data.model.GitResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoListRepository(val apiService: ApiService) {

    // GET repo list
    fun getRepoList(onResult: (isSuccess: Boolean, response: GitResponse?) -> Unit) {

        apiService.getRepo().enqueue(object : Callback<GitResponse> {
            override fun onResponse(call: Call<GitResponse>?, response: Response<GitResponse>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<GitResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }
}