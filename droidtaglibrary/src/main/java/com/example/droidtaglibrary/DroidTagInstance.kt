package com.example.droidtaglibrary

import android.content.Context
import android.util.AttributeSet
import android.widget.AutoCompleteTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DroidTagInstance : ConstraintLayout {


    lateinit var _parentContainer: ConstraintLayout
    lateinit var _rv: RecyclerView
    lateinit var _actv_tag: AutoCompleteTextView
    lateinit var _fab_check: FloatingActionButton


    constructor(context: Context) : super(context) {
        init(context, null, null, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(
        context, attrs
    ) {
        init(context, attrs, null, null)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr, null)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context, attrs, defStyleAttr, defStyleRes)
    }


    private fun init(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int?,
        defStyleRes: Int?
    ) {

        print("In DroidInstance Init")

        //Init UI components
        _rv = RecyclerView(context, attrs)
        _rv.id = R.id.rv_droidtags

        _fab_check = FloatingActionButton(context, attrs)
        _fab_check.id = R.id.fab_check


        _actv_tag = AutoCompleteTextView(context, attrs)
        _actv_tag.id = R.id.actv_droidtag

        _parentContainer = ConstraintLayout(context, attrs)
        _parentContainer.id = R.id.container_droidtag

        print("Initialized as $_parentContainer and $_fab_check")


    }

}