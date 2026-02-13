package com.example.retrofitjc_di.api

import com.example.retrofitjc_di.dataClasses.UsersItem
import retrofit2.http.GET


interface ApiInterface {

//    https://jsonplaceholder.typicode.com/users
    @GET("users")
    suspend fun getAllUsers() : List<UsersItem>
}