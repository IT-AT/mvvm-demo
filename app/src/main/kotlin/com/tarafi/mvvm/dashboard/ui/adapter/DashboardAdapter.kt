package com.tarafi.mvvm.dashboard.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tarafi.mvvm.R
import com.tarafi.mvvm.dashboard.data.entities.ItemSample

class DashboardAdapter(val mContext: Context, var characterList: List<ItemSample>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.adapter_character_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return characterList?.size ?: 0
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}
