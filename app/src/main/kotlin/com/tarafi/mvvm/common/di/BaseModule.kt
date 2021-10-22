package com.tarafi.mvvm.common.di

import com.tarafi.mvvm.common.app.activity.MainActivity
import dagger.Module
import dagger.Provides

@Module
class BaseModule(val mainActivity: MainActivity) {

    @Provides
    @PerFragment
    fun provideActivity(): MainActivity {
        return mainActivity
    }
}