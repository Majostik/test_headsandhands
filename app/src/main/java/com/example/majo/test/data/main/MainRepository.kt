package com.example.majo.test.data.main

import com.example.majo.test.data.api.Api
import com.example.majo.test.data.api.model.Data
import io.reactivex.Single
import javax.inject.Inject

class MainRepository @Inject constructor(val apiService: Api) {

    fun signIn(email: String, password: String): Single<Data>
        = apiService.getWeather()
}