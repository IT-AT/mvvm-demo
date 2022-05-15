package com.tarafi.mvvm.common.di

import com.tarafi.mvvm.common.data.executor.JobExecutor
import com.tarafi.mvvm.common.domain.executor.PostExecutionThread
import com.tarafi.mvvm.common.domain.executor.ThreadExecutor
import com.tarafi.mvvm.common.domain.interactor.UiThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by TARAFI Ahmed on 06/11/2021
 */
@Module
class UIModule {
    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }
}