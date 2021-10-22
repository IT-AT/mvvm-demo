package com.tarafi.mvvm.common.di

import com.tarafi.mvvm.common.app.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}