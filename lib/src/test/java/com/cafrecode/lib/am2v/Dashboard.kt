package com.cafrecode.lib.am2v

data class Dashboard(
    var receiving: Double? = 0.0,
    var loading: Double? = 0.0,
    var drying: Double? = 0.0,
    var offloading: Double? = 0.0,
    var sorting: Double? = 0.0,
    var packing: Double? = 0.0
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
