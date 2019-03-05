package com.example.majo.test_hah.base


interface BasePresenter<in T : BaseView> {

    fun takeView(t: T)

    fun detachFromView()
}
