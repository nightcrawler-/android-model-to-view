/*
 * MIT License
 *
 * Copyright (c) 2021  Frederick Nyawaya
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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