package com.daivansh.mvvmkotlinsample.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.daivansh.mvvmkotlinsample.api.ApiFactory
import com.daivansh.mvvmkotlinsample.api.ApiService
import com.daivansh.mvvmkotlinsample.api.Project
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectDetailsViewModel: ViewModel() {
    private lateinit var project: MutableLiveData<Project>

    fun getProjectDetail(projectName: String) : LiveData<Project> {
        if(!::project.isInitialized){
            project= MutableLiveData()
            getProjectDetailFromApi(projectName)
        }
        return project
    }

    private fun getProjectDetailFromApi(projectName: String) {
        val apiService: ApiService = ApiFactory.getapiInstance()
        apiService.getProjectDetails("Google",projectName).enqueue(object : Callback<Project> {

            override fun onResponse(call: Call<Project>, response: Response<Project>) {
                project.value=response.body()
            }

            override fun onFailure(call: Call<Project>, t: Throwable) {
                Log.d(TAG,t.localizedMessage)
            }

        })
    }

    companion object {
        private const val TAG: String="ProjectListVM.class"
    }
}