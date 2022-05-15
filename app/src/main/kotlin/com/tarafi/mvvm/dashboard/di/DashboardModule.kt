package com.tarafi.mvvm.dashboard.di

import com.tarafi.mvvm.common.di.PerFragment
import com.tarafi.mvvm.common.domain.interactor.BaseSingleUseCase
import com.tarafi.mvvm.dashboard.data.entities.ItemSample
import com.tarafi.mvvm.dashboard.data.repository.DashboardRepositoryImpl
import com.tarafi.mvvm.dashboard.domain.interactor.GetItemsUseCase
import com.tarafi.mvvm.dashboard.domain.repository.DashboardRepository
import dagger.Module
import dagger.Provides

@Module
class DashboardModule {

    @Provides
    @PerFragment
    fun provideGetItemsUseCase(getItemsUseCase: GetItemsUseCase): BaseSingleUseCase<Void, List<ItemSample>> {
        return getItemsUseCase
    }

    @Provides
    @PerFragment
    fun provideDashboardRepository(dashboardRepositoryImpl: DashboardRepositoryImpl): DashboardRepository {
        return dashboardRepositoryImpl
    }
}