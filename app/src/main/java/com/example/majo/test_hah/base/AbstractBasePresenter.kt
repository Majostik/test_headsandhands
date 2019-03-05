package com.example.majo.test_hah.base


import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T> {

    private var view: WeakReference<T>? = null
    private val disposables = CompositeDisposable()

    override fun takeView(t: T) {
        view = WeakReference(t)
    }

    override fun detachFromView() {
        disposables.clear()
        view = null
    }

    fun getView() = view?.get()

    fun disposeCheck(disposable: Disposable) {
        if (!disposable.isDisposed)
            disposable.dispose()
    }
}
