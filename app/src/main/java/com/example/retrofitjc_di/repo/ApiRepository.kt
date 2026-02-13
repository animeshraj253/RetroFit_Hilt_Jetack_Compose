package com.example.retrofitjc_di.repo

import com.example.retrofitjc_di.api.ApiInterface
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiInterface : ApiInterface){
    // getting all users from API
    suspend fun getAllUsers () = apiInterface.getAllUsers()
}