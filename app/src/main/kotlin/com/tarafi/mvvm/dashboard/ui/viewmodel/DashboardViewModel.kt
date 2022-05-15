package com.tarafi.mvvm.dashboard.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tarafi.mvvm.common.ui.viewmodel.BaseViewModel
import com.tarafi.mvvm.dashboard.data.entities.ItemSample
import com.tarafi.mvvm.dashboard.domain.interactor.GetItemsUseCase
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

/**
 * Created by TARAFI Ahmed on 06/11/2021
 */
class DashboardViewModel : BaseViewModel() {
    @Inject
    lateinit var getItemsUseCase: GetItemsUseCase

    private val ItemsList: MutableLiveData<List<ItemSample>> by lazy {
        MutableLiveData<List<ItemSample>>().also {
            loadList()
        }
    }

    fun getCharactersList(): LiveData<List<ItemSample>> {
        return ItemsList
    }

    private fun loadList() {
        val singleObserver = object : DisposableSingleObserver<List<ItemSample>>() {
            override fun onSuccess(listItems: List<ItemSample>) {
                Thread.sleep(5000)
                ItemsList.postValue(listItems)
            }

            override fun onError(e: Throwable) {
                //state = MovieState.Error(e.localizedMessage)
            }
        }
        getItemsUseCase.execute(singleObserver)
    }
}