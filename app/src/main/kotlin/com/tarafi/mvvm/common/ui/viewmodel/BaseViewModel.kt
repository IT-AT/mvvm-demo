package com.tarafi.mvvm.common.ui.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Created by TARAFI Ahmed on 06/11/2021
 */
abstract class BaseViewModel : ViewModel() {
    private val disposables: CompositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    private fun clearDisposables() {
        if (disposables.isDisposed.not())
            disposables.clear()
    }

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        clearDisposables()
    }
}
