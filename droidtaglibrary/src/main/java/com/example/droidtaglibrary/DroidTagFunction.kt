package com.example.droidtaglibrary

import android.content.Context
import android.view.LayoutInflater
import android.widget.AutoCompleteTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DroidTagFunction constructor(builder: DroidTagBuilder) {

    private val mLayoutInflater: LayoutInflater
    private val context: Context

    private val _parentContainer: ConstraintLayout
    private val _rv: RecyclerView
    private val _actv_tag: AutoCompleteTextView
    private val _fab_check: FloatingActionButton


    private var adapterTagsAdded: DroidTagAdapter = DroidTagAdapter()
    private var mutableTagList: MutableList<String> = mutableListOf()


    init {
        print("In DroidTagFunction  init")

        context = builder.context
        mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        _parentContainer = builder.layout_parentContainer
        _actv_tag = builder.layout_actv_tag
        _rv = builder.layout_rv
        _fab_check = builder.layout_fab_check


        _fab_check.setOnClickListener {
            onClickCheck()
        }


    }


    /**
     * This returns the list of all the tags to populate. This is the only function exposed to the user
     */
    fun getTheList(): MutableList<String> {
        return mutableTagList
    }


    /**
     * This is triggered when we click the Floating Action Button Instance
     */
    private fun onClickCheck() {

        if (!_actv_tag.text.isNullOrEmpty()) {
            print("Tag added = ${_actv_tag.text}")
            mutableTagList.add(_actv_tag.text.toString())
            setInTagRv()
            _actv_tag.text = null
        } else {
            print("No tag added")
        }
    }


    private fun setInTagRv() {

        print("Setting the Tag in the recycler view holder")
        adapterTagsAdded.tagAdded = mutableTagList
        val l = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        _rv.layoutManager = l
        _rv.adapter = adapterTagsAdded

    }


}


