package com.tarafi.mvvm.dashboard.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tarafi.mvvm.R
import com.tarafi.mvvm.common.di.ApplicationComponent
import com.tarafi.mvvm.common.ui.fragment.BaseFragment
import com.tarafi.mvvm.dashboard.ui.adapter.DashboardAdapter
import com.tarafi.mvvm.dashboard.ui.viewmodel.DashboardViewModel
import com.tarafi.mvvm.databinding.DashboardFragmentBinding

/**
 * Created by TARAFI Ahmed on 06/11/2021
 */
class DashboardFragment : BaseFragment() {
    private val dashboardViewModel: DashboardViewModel by viewModels()
    private lateinit var dashBinding: DashboardFragmentBinding

    override fun initializeInjector(applicationComponent: ApplicationComponent) {
        val dashboardComponent = applicationComponent.dashboardComponent.create()
        dashboardComponent.inject(this)
        dashboardComponent.inject(dashboardViewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dashboard_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dashBinding = DashboardFragmentBinding.bind(view)

        dashBinding.message.text = getString(R.string.label_loading)
        dashBinding.progressBar.visibility = View.VISIBLE
        val dashboardAdapter = DashboardAdapter(requireContext(), null)
        dashBinding.charactersRv.adapter = dashboardAdapter
        dashBinding.charactersRv.layoutManager = LinearLayoutManager(activity)
        dashboardViewModel.getCharactersList()
            .observe(viewLifecycleOwner, Observer { itemsList ->
                dashBinding.progressBar.visibility = View.GONE
                dashBinding.message.text = getString(R.string.label_success)
                dashBinding.charactersRv.adapter = DashboardAdapter(requireContext(), itemsList)
            })
    }
}