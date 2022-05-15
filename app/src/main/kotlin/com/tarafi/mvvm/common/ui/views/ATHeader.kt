package com.tarafi.mvvm.common.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.tarafi.mvvm.R
import com.tarafi.mvvm.common.ui.activity.MainActivity
import com.tarafi.mvvm.databinding.ViewHeaderBinding

class ATHeader : RelativeLayout {

    private var mContext: Context
    private lateinit var viewHeaderBinding: ViewHeaderBinding

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        mContext = context
        init(attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    ) {
        mContext = context
        init(attributeSet)
    }

    private fun init(attributeSet: AttributeSet) {
        View.inflate(mContext, R.layout.view_header, this)
        viewHeaderBinding = ViewHeaderBinding.bind(this)
        val typedArray = mContext.obtainStyledAttributes(attributeSet, R.styleable.ATHeader, 0, 0)
        val headerTitle = typedArray.getString(R.styleable.ATHeader_header_title)
        val rightIcnDrw = typedArray.getDrawable(R.styleable.ATHeader_header_right_icn)
        val btnBackVisible = typedArray.getBoolean(R.styleable.ATHeader_header_back, false)
        if (btnBackVisible) {
            viewHeaderBinding.btnMenu.visibility = View.GONE
            viewHeaderBinding.btnBack.visibility = View.VISIBLE
        } else {
            //btnMenu.visibility=View.VISIBLE
            viewHeaderBinding.btnBack.visibility = View.GONE

        }
        viewHeaderBinding.titleTextView.text = headerTitle ?: ""
        viewHeaderBinding.imgRight.setImageDrawable(rightIcnDrw)
        /*btnMenu.setOnClickListener {
            val mainActivity = mContext as MainActivity
            mainActivity.actionMenu()
        }*/

        viewHeaderBinding.btnBack.setOnClickListener {
            val mainActivity = mContext as MainActivity
            mainActivity.onBackPressed()
        }

    }

    fun setHeaderTitleText(headerTitle: Int) {
        viewHeaderBinding.titleTextView.setText(headerTitle)
    }

    fun setOnBackBtnListener(onBackBtnCLickListener: (() -> Unit)?) {
        viewHeaderBinding.btnBack.setOnClickListener {
            onBackBtnCLickListener?.invoke()
        }
    }

    fun setImgRightClickListener(onImgRightBtnCLickListener: (() -> Unit)?) {
        viewHeaderBinding.imgRight.setOnClickListener {
            onImgRightBtnCLickListener?.invoke()
        }
    }

    fun setImgRightVisibility(visibility: Int) {
        viewHeaderBinding.imgRight.visibility = visibility
    }
}