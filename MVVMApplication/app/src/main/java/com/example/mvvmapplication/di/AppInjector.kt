package com.example.mvvmapplication.di

import android.content.SharedPreferences
import com.example.mvvmapplication.data.api.ApiClient
import com.example.mvvmapplication.data.repository.RepoListDataStore
import com.example.mvvmapplication.domain.GetRepoListUseCase
import com.example.mvvmapplication.viewmodel.RepoListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.experimental.builder.single


val viewModelModule = module {
    viewModel { RepoListViewModel(get()) }
}

val useCaseModule = module {
    single { GetRepoListUseCase(get<RepoListDataStore>()) }
}

val repositoryModule = module {
    single { RepoListDataStore(get()) }
}

val networkModule = module {
    single { ApiClient.create(okHttpClient = get()) }
    single { ApiClient.getOkHttpClient(authInterceptor = get()) }
    single { ApiClient.getAuthInterceptor(sharedPreferences = get()) }
}


val sharedPrefModule = module {
    single {
        androidApplication().getSharedPreferences("default", android.content.Context.MODE_PRIVATE)
    }

    single<SharedPreferences.Editor> {
        androidApplication().getSharedPreferences("default", android.content.Context.MODE_PRIVATE)
            .edit()
    }
}