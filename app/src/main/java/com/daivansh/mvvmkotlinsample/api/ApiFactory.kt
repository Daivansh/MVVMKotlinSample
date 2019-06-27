package com.daivansh.mvvmkotlinsample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {

    companion object {

        fun getapiInstance(): ApiService {
                val retrofit: Retrofit = Retrofit.Builder().apply {
                    baseUrl("https://api.github.com/")
                    addConverterFactory(GsonConverterFactory.create())
                }.build()
            return retrofit.create(ApiService::class.java)
        }
    }

}