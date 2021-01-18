package com.example.test_uas.repository

import com.example.test_uas.model.ActionState
import com.example.test_uas.model.User
import com.example.test_uas.remote.HomeService
import com.example.test_uas.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class HomeRepository {
    private val homeService: HomeService by lazy { RetrofitApi.homeService() }

    suspend fun listHome() : ActionState<List<User>> {
        try {
            val list = newService.listUser().await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailNews(url: String) : ActionState<User> {
        try {
            val list = homeService.detailUser(url).await()
            ActionState(list.data.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchNews(query: String) : ActionState<List<User>> {
        try {
            val list = homeService.searchUser(query).await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}