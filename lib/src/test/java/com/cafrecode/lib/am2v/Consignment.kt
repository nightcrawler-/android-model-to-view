package com.cafrecode.lib.am2v

import com.cafrecode.lib.am2v.annotations.Capitalize
import com.cafrecode.lib.am2v.annotations.IgnoreExtraction
import com.cafrecode.lib.am2v.annotations.MeasurementUnit

data class Consignment(

    @IgnoreExtraction
    var id: String, //locally generated value to track or consignment status on local (save only last one), likely ignored when serializing

    var productType: String? = "",

    @IgnoreExtraction
    var lotNumber: String? = "",

    var numberOfBags: String? = "",

    var receivingForm: String? = "No Image Available",

    @MeasurementUnit(name = "Kgs") var weight: String? = "",
    @MeasurementUnit(name = "%") var moisture: String? = "",
    @Capitalize var skr: String? = ""
//Note: Using var instead of val because 2-way data binding, meh!
)