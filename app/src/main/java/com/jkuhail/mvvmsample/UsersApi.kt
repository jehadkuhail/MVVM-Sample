package com.jkuhail.mvvmsample

import com.jkuhail.mvvmsample.model.UsersResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface UsersApi {

    @GET("users?page=2")
    suspend fun getUsers(): Response<UsersResponse>

    companion object{
        operator fun invoke() : UsersApi{
            return Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient())
                .build()
                .create(UsersApi::class.java)
        }
    }
}