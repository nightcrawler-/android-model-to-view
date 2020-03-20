package com.cafrecode.lib.am2v

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : RecyclerView.ViewHolder?> :
    RecyclerView.Adapter<T>() {

    var content: List<Result>? = null
        set(value) {
            field = value
            this.notifyDataSetChanged()
        }
}