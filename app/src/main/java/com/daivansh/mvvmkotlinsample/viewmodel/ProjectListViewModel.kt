package com.daivansh.mvvmkotlinsample.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.daivansh.mvvmkotlinsample.api.Project
import com.daivansh.mvvmkotlinsample.api.ApiFactory
import com.daivansh.mvvmkotlinsample.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectListViewModel : ViewModel() {
    private lateinit var projectList: MutableLiveData<List<Project>>


    fun getProjectsList() : LiveData<List<Project>> {
        if(!::projectList.isInitialized){
            projectList=MutableLiveData()
            buildListFromApi()
        }
        return projectList
    }

    private fun buildListFromApi() {
        val apiService: ApiService = ApiFactory.getapiInstance()
        apiService.getProjectList("Google").enqueue(object : Callback<List<Project>> {

            override fun onResponse(call: Call<List<Project>>, response: Response<List<Project>>) {
               projectList.value=response.body()
            }

            override fun onFailure(call: Call<List<Project>>, t: Throwable) {
               Log.d(TAG,t.localizedMessage)
            }
        })
    }
    companion object {
        const val TAG: String="ProjectListVM.class"
    }
}