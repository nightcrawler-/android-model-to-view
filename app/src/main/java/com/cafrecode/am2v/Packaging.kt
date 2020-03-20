package com.cafrecode.am2v

import com.cafrecode.lib.am2v.annotations.Capitalize
import com.cafrecode.lib.am2v.annotations.ExtractedName
import com.cafrecode.lib.am2v.annotations.IgnoreExtraction
import com.cafrecode.lib.am2v.annotations.MeasurementUnit

data class Packaging(

    @IgnoreExtraction
    var id: String, //locally generated value to track or consignment status on local (save only last one), likely ignored when serializing

    @IgnoreExtraction var batchId: String? = "",
    @ExtractedName(name = "# of 25lb Units") var lbUnits: String? = "",

    @MeasurementUnit(name = "%") var moisture: String? = "",
    var other: String? = "",

    @Capitalize var bbn: String? = "",

    @MeasurementUnit(name = "Kgs") var s0: String? = "",
    @MeasurementUnit(name = "Kgs") var s1s: String? = "",
    @MeasurementUnit(name = "Kgs") var s1l: String? = "",
    @MeasurementUnit(name = "Kgs") var s2: String? = "",
    @MeasurementUnit(name = "Kgs") var s4s: String? = "",
    @MeasurementUnit(name = "Kgs") var s4l: String? = "",
    @MeasurementUnit(name = "Kgs") var s5: String? = "",
    @MeasurementUnit(name = "Kgs") var s6: String? = "",

    var url: String? = "No Image Available"


//Note: Using var instead of val because 2-way data binding, meh!
)
