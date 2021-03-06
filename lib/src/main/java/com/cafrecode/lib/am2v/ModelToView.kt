package com.cafrecode.lib.am2v

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//TODO: This class could use some refinements, minimize repetition
class ModelToView {

    private val recyclerView: RecyclerView
    lateinit var adapter: BaseAdapter<RecyclerView.ViewHolder>

    /**
     * Default constructor will use the default results adapter. Custom adapters can be applied. Default layoutmanager
     */
    constructor(recyclerView: RecyclerView) {
        this.recyclerView = recyclerView
        this.adapter = ResultsAdapter() as BaseAdapter<RecyclerView.ViewHolder>
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = adapter
    }

    /**
     * To use a custom adapter. Makesure to set the required layout manager on your recycler view
     */
    constructor(recyclerView: RecyclerView, adapter: BaseAdapter<RecyclerView.ViewHolder>) {
        this.adapter = adapter
        this.recyclerView = recyclerView
        recyclerView.adapter = adapter
    }


    fun setModel(model: Any) {
        adapter.content = FieldsUtil.getFieldValuePairs(model)
    }

}