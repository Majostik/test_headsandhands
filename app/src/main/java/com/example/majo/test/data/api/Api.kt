package com.example.majo.test.data.api

import com.example.majo.test.data.api.model.Data
import io.reactivex.Single
import retrofit2.http.GET

interface Api {

    @GET(WEATHER)
    fun getWeather(): Single<Data>

    companion object {
        const val WEATHER = "weather?q=London&appid=d679b6d8c9aa2668883cf025b1f22b99"
    }

}