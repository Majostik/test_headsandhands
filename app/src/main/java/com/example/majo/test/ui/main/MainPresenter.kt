package com.example.majo.test.ui.main

import com.example.majo.test.base.AbstractBasePresenter
import com.example.majo.test.di.activity.ActivityScope
import com.example.majo.test.domain.main.MainInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class MainPresenter @Inject constructor(val mainInteractor: MainInteractor) : AbstractBasePresenter<MainView>() {

    fun signIn(email: String, password: String){
        mainInteractor.signIn(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it -> getView()?.onGetResult(it) }, { t -> getView()?.onError(t.message) })
    }

}
