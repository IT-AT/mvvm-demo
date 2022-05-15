package com.tarafi.mvvm.common.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.tarafi.mvvm.MvvmApplication
import com.tarafi.mvvm.common.di.ApplicationComponent
import javax.inject.Inject

/**
 * Created by TARAFI Ahmed on 06/11/2021
 */
open class BaseFragment : Fragment() {

    @Inject
    lateinit var appContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeInjector(getApplicationComponent())
    }

    open fun initializeInjector(applicationComponent: ApplicationComponent) {
        applicationComponent.baseComponent.create().inject(this)
    }

    private fun getApplicationComponent(): ApplicationComponent {
        val application = requireActivity().application as MvvmApplication
        return application.appComponent
    }
}