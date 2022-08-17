package com.example.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.sharedPrefs.SharedPrefUserStorage
import com.example.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepositoryImpl by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            userStorage = SharedPrefUserStorage(context)
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepositoryImpl
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepositoryImpl
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(saveUserNameUseCase, getUserNameUseCase) as T
    }
}