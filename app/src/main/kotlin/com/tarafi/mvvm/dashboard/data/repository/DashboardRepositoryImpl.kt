package com.tarafi.mvvm.dashboard.data.repository

import com.tarafi.mvvm.dashboard.data.entities.ItemSample
import com.tarafi.mvvm.dashboard.domain.repository.DashboardRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor() : DashboardRepository {
    override fun getItemsList(): Single<List<ItemSample>> {
        val listItems = ArrayList<ItemSample>()
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        listItems.add(ItemSample())
        return Single.just(listItems)
    }
}