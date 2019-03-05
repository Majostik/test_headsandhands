package com.example.majo.test.base


interface BasePresenter<in T : BaseView> {

    fun takeView(t: T)

    fun detachFromView()
}
