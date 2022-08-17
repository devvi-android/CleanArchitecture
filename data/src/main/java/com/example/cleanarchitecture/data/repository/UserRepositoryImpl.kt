package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.storage.UserStorage
import com.example.cleanarchitecture.data.storage.models.User
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveUser(param: SaveUserNameParam): Boolean {
        val user = mapToStorage(param)
        return userStorage.save(user)
    }

    override fun getUser(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(param: SaveUserNameParam): User {
        return User(param.name, "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(user.firstName, user.lastName)
    }
}