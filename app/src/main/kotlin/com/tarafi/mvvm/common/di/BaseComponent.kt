package com.tarafi.mvvm.common.di

import com.tarafi.mvvm.common.ui.fragment.BaseFragment
import dagger.Subcomponent

/**
 * Created by TARAFI Ahmed on 06/11/2021
 */
@PerFragment
@Subcomponent
interface BaseComponent {

    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): BaseComponent
    }

    fun inject(baseFragment: BaseFragment)
}