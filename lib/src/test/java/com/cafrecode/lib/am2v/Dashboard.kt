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
