package com.tarafi.mvvm

import android.app.Application
import com.tarafi.mvvm.common.di.ApplicationComponent
import com.tarafi.mvvm.common.di.ApplicationModule
import com.tarafi.mvvm.common.di.DaggerApplicationComponent

class MvvmApplication : Application() {

    private lateinit var appComponent: ApplicationComponent
    private lateinit var appModule: ApplicationModule

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    private fun initializeInjector(){
        appModule= ApplicationModule(this)
        appComponent = DaggerApplicationComponent.builder().build()
    }

    fun getAppComponent(): ApplicationComponent {
        return appComponent
    }

    fun getAppModule(): ApplicationModule {
        return appModule
    }
}