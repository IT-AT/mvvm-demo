package com.tarafi.mvvm.dashboard.domain.repository

import com.tarafi.mvvm.dashboard.data.entities.ItemSample
import io.reactivex.rxjava3.core.Single

interface DashboardRepository {
    fun getItemsList(): Single<List<ItemSample>>
}