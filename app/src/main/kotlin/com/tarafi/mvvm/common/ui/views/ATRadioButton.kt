package com.tarafi.mvvm.common.ui.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatRadioButton
import com.tarafi.mvvm.R
import com.tarafi.mvvm.utils.ATFontUtils

class ATRadioButton : AppCompatRadioButton {
    private var mContext: Context;

    constructor(context: Context) : super(context) {
        mContext = context
        setTypeface(ATFontUtils.getTypeface(mContext, ATFontUtils.LATO, ATFontUtils.REGULAR))
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        mContext = context
        if (!isInEditMode) {
            applyCustomFont(attributeSet)
        }
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    ) {
        mContext = context
        if (!isInEditMode) {
            applyCustomFont(attributeSet)
        }

    }

    private fun applyCustomFont(attributeSet: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.View, 0, 0)
        val fontName = typedArray.getInt(R.styleable.View_font_name, ATFontUtils.LATO)
        val fontType = typedArray.getInt(R.styleable.View_font_type, ATFontUtils.REGULAR)
        typeface = ATFontUtils.getTypeface(mContext, fontName, fontType)
    }

}