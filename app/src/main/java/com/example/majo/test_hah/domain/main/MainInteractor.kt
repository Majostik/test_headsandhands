package com.example.majo.test_hah.domain.main

import com.example.majo.test_hah.data.api.model.Data
import com.example.majo.test_hah.data.main.MainRepository
import io.reactivex.Single
import javax.inject.Inject

class MainInteractor @Inject constructor(val mainRepository: MainRepository) {

    fun signIn(email: String, password: String): Single<Data> =
        mainRepository.signIn(email, password)
}