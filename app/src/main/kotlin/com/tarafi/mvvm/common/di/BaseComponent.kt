package com.tarafi.mvvm.common.di

import com.tarafi.mvvm.common.app.fragment.BaseFragment
import dagger.Component

@PerFragment
@Component(dependencies = [ApplicationComponent::class], modules = [BaseModule::class])
interface BaseComponent {
    fun inject(baseFragment: BaseFragment)
}