package com.example.cleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase
) : ViewModel() {

    private val resultLiveDataMutable = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultLiveDataMutable

    fun save(param: String) {
        val params = SaveUserNameParam(param)
        val data: Boolean = saveUserNameUseCase.execute(params)
        resultLiveDataMutable.value = "Save result: $data"
    }

    fun get() {
        val getUserName: UserName = getUserNameUseCase.execute()
        resultLiveDataMutable.value = "${getUserName.firstName} ${getUserName.lastName}"
    }

}