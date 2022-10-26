package com.example.droidtaglibrary

import android.content.Context
import android.widget.AutoCompleteTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DroidTagBuilder(
    val context: Context,
    droidtagInstance: DroidTagInstance
) {

    val layout_parentContainer: ConstraintLayout
    val layout_rv: RecyclerView
    val layout_actv_tag: AutoCompleteTextView
    val layout_fab_check: FloatingActionButton


    init {
        print("In DroidBuilder Init")
        layout_parentContainer = droidtagInstance._parentContainer
        layout_rv = droidtagInstance._rv
        layout_actv_tag = droidtagInstance._actv_tag
        layout_fab_check = droidtagInstance._fab_check


    }


    fun build(): DroidTagFunction {
        print("In DroidTag Build")
        return DroidTagFunction(this)
    }


}