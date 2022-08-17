package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.models.UserName

interface UserRepository {

    fun saveUser(param: SaveUserNameParam): Boolean

    fun getUser(): UserName
}