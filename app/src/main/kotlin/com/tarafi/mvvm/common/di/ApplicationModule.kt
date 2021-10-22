package com.tarafi.mvvm.common.di

import android.content.Context
import com.tarafi.mvvm.MvvmApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val application: MvvmApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }
}