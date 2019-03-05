package com.example.majo.test_hah

import android.app.Activity
import android.app.Application
import com.example.majo.test_hah.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject



class Application : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .context(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

}