package com.cafrecode.lib.am2v

import com.cafrecode.lib.am2v.annotations.Index
import com.cafrecode.lib.am2v.annotations.Ordered

@Ordered
data class Dashboard(
    @Index(value = 0) var receiving: Double? = 0.0,
    @Index(value = 1) var loading: Double? = 0.0,
    @Index(value = 3) var drying: Double? = 0.0,
    @Index(value = 2) var offloading: Double? = 0.0,
    @Index(value = 4) var sorting: Double? = 0.0,
    @Index(value = 5) var packing: Double? = 0.0
)

/*
        "d_date": "18-03-2020",
        "receiving": "30",
        "loading": "10.5",
        "offloading": "14",
        "inshell_sorting": "6",
        "kernel_sorting": "4.5",
        "packing": 63.8
 */
