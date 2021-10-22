package com.tarafi.mvvm.common.app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tarafi.mvvm.MvvmApplication
import com.tarafi.mvvm.common.app.activity.MainActivity
import com.tarafi.mvvm.common.di.ApplicationComponent
import com.tarafi.mvvm.common.di.BaseModule
import com.tarafi.mvvm.common.di.DaggerBaseComponent
import javax.inject.Inject

class BaseFragment : Fragment() {

    @Inject
    lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeInjector(getApplicationComponent())
    }

    open fun initializeInjector(applicationComponent: ApplicationComponent){
        val baseComponent = DaggerBaseComponent.builder().applicationComponent(applicationComponent).baseModule(
            BaseModule(activity as MainActivity)
        ).build()
        baseComponent.inject(this)
    }

    private fun getApplicationComponent() : ApplicationComponent {
        val mvpDemoApplication = requireActivity().application as MvvmApplication
        return mvpDemoApplication.getAppComponent()
    }
}