package com.example.majo.test_hah.data.api

import com.example.majo.test_hah.data.api.model.Data
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET(WEATHER)
    fun getWeather(): Single<Data>

    companion object {
        const val WEATHER = "weather?q=London&appid=d679b6d8c9aa2668883cf025b1f22b99"
    }

}