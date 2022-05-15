package com.tarafi.mvvm

import android.app.Application
import com.tarafi.mvvm.common.di.ApplicationComponent
import com.tarafi.mvvm.common.di.DaggerApplicationComponent

/**
 * Created by TARAFI Ahmed on 06/11/2021
 */
class MvvmApplication : Application() {

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: ApplicationComponent by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerApplicationComponent.factory().create(this)
    }
}