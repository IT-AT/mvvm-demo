package com.tarafi.mvvm.common.di

import android.content.Context
import com.tarafi.mvvm.common.ui.activity.MainActivity
import com.tarafi.mvvm.dashboard.di.DashboardComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by TARAFI Ahmed on 06/11/2021
 */
@Singleton
@Component(
    modules = [ApplicationModule::class,
        UIModule::class]
)
interface ApplicationComponent {
    val baseComponent: BaseComponent.Factory
    val dashboardComponent: DashboardComponent.Factory

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(mainActivity: MainActivity)
}