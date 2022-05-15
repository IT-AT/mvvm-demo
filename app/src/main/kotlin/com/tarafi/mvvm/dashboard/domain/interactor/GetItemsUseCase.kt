package com.tarafi.mvvm.dashboard.domain.interactor

import com.tarafi.mvvm.common.domain.executor.PostExecutionThread
import com.tarafi.mvvm.common.domain.executor.ThreadExecutor
import com.tarafi.mvvm.common.domain.interactor.BaseSingleUseCase
import com.tarafi.mvvm.dashboard.data.entities.ItemSample
import com.tarafi.mvvm.dashboard.domain.repository.DashboardRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val dashboardRepository: DashboardRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) :
    BaseSingleUseCase<Void, List<ItemSample>>(threadExecutor, postExecutionThread) {
    override fun buildUseCaseObservable(requestValues: Void?): Single<List<ItemSample>> {
        return dashboardRepository.getItemsList()
    }
}