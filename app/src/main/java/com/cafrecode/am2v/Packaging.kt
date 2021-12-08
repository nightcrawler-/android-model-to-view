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
