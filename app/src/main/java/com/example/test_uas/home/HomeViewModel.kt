package com.example.test_uas.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_uas.model.ActionState
import com.example.test_uas.model.User
import com.example.test_uas.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repo: HomeRepository by lazy { HomeRepository() }

    val loading = MutableLiveData{false}
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<User>>()
    val detailResp = MutableLiveData<User>()
    val searchResp = MutableLiveData<List<User>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listUser() {
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listHome()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailUser(url:String? = this.url.value) {
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = resp.detailUser(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }
    }

    fun searchUser(query: String? = this.query.value) {
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = resp.searchUser(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}