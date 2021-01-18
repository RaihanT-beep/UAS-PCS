package com.example.test_uas.remote

import com.example.test_uas.model.UserList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {
    @GET("/")
    fun listUser() : Call<UserList>

    @GET("/")
    fun detailUser(@Query("url") url: String) : Call<UserList>

    @GET("search/")
    fun searchUser(@Query("q") query: String) : Call<UserList>
}