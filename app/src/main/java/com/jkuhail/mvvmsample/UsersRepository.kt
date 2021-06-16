package com.jkuhail.mvvmsample

class UsersRepository(
    private val api: UsersApi
) : SafeApiRequest() {

    suspend fun getUsers() = apiRequest { api.getUsers() }
}