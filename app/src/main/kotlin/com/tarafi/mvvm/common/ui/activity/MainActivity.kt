package com.tarafi.mvvm.common.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tarafi.mvvm.R
import com.tarafi.mvvm.dashboard.ui.fragment.DashboardFragment

/**
 * Created by TARAFI Ahmed on 06/11/2021
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(DashboardFragment())
    }

    fun addFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frame_container, fragment)
        fragmentTransaction.commit()
    }

    fun switchFragment(fragment: Fragment, addToBackStack: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container, fragment)
        when {
            addToBackStack -> fragmentTransaction.addToBackStack(fragment.tag)
            else -> return
        }
        fragmentTransaction.commit()
    }
}