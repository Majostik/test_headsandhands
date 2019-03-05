package com.example.majo.test.di

import com.example.majo.test.di.activity.ActivityScope
import com.example.majo.test.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
@Module(includes = arrayOf(AndroidSupportInjectionModule::class))
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector
    fun mainActivity(): MainActivity

}
