package com.tarafi.mvvm.dashboard.di

import com.tarafi.mvvm.common.di.PerFragment
import com.tarafi.mvvm.dashboard.ui.fragment.DashboardFragment
import com.tarafi.mvvm.dashboard.ui.viewmodel.DashboardViewModel
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = [DashboardModule::class])
interface DashboardComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DashboardComponent
    }

    fun inject(dashboardFragment: DashboardFragment)
    fun inject(dashboardViewModel: DashboardViewModel)
}