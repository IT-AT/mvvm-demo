package com.tarafi.mvvm.common.domain.interactor

import com.tarafi.mvvm.common.domain.executor.PostExecutionThread
import com.tarafi.mvvm.common.domain.executor.ThreadExecutor
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableCompletableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by TARAFI Ahmed on 06/11/2021
 * This kind of observable doesn't return a value (equivalent to void)
 */
abstract class CompletableUseCase<in Params> constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {

    protected abstract fun buildUseCaseObservable(requestValues: Params? = null): Completable

    open fun execute(observer: DisposableCompletableObserver, params: Params? = null) {
        val completable = this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
        addDisposable(completable.subscribeWith(observer))
    }

    open fun execute(
        singleObserver: DisposableCompletableObserver,
        params: Params? = null,
        scheduler: Scheduler
    ) {
        val single = this.buildUseCaseObservable(params).subscribeOn(
            Schedulers.from(threadExecutor)
        ).observeOn(scheduler)
        addDisposable(single.subscribeWith(singleObserver))
    }

    private val disposables = CompositeDisposable()

    fun dispose() {
        if (disposables.isDisposed.not()) disposables.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}
