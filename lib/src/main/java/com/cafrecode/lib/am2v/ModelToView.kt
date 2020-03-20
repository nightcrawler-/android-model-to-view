package com.cafrecode.lib.am2v

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ModelToView {

    companion object {

        private val adapter = ResultsAdapter()
        /**
         * Pass in the model and the recyclerview that is intended to host the models content
         */
        @JvmStatic
        fun `for`(model: Object, recyclerView: RecyclerView) {
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.adapter = adapter
            adapter.content = FieldsUtil.getFieldValuePairs(model)
        }
    }
}