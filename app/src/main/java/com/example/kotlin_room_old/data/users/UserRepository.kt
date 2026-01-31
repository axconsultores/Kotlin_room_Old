package com.example.kotlin_room_old.data.users

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAlldata: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user : User){
        userDao.addUser(user)
    }


}