package com.example.kotlin_room_old.data.users

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application){

    private var readAllData : LiveData<List<User>>

    private var repository : UserRepository


    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData= repository.readAlldata
    }

    fun addUser(user: User) {

        viewModelScope.launch(Dispatchers.IO) {

            repository.addUser(user)

        }

    }




}