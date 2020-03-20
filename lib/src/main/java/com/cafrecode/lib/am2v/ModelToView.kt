package com.cafrecode.lib.am2v

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ModelToView {

    private val recyclerView: RecyclerView
    private val adapter = ResultsAdapter()

    constructor(recyclerView: RecyclerView) {
        this.recyclerView = recyclerView
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = adapter
    }

    fun setModel(model: Any) {
        adapter.content = FieldsUtil.getFieldValuePairs(model)
    }

}