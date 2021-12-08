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

import junit.framework.Assert.assertEquals
import org.junit.Test


internal class FieldsUtilTest {

    @Test
    fun getFieldValuePairs() {

        val consignment = Consignment("1", "Ndumaa", "ME", "ME", "ME")
        val results = FieldsUtil.getFieldValuePairs(consignment)

        assertEquals(6, results.size)
        assertEquals("Ndumaa", results[0].content)
        assertEquals("Product Type:", results[0].title)

        val packaging = Packaging(
            "12", "12", "45", "67",
            "87", null, "09", "34", "54", "54", "34", "34"
        )

        val packagingResult = FieldsUtil.getFieldValuePairs(packaging)

        assertEquals("# of 25lb Units:", packagingResult[0].title)
        assertEquals("45", packagingResult[0].content)

        assertEquals("Moisture:", packagingResult[1].title)
        assertEquals("67 %", packagingResult[1].content)

        assertEquals("BBN:", packagingResult[3].title)
        assertEquals("0", packagingResult[3].content)

        assertEquals("S 0:", packagingResult[4].title)
        assertEquals("09 Kgs", packagingResult[4].content)

        assertEquals("S 1s:", packagingResult[5].title)
        assertEquals("34 Kgs", packagingResult[5].content)

        val dashboard = Dashboard(12.0, null, 9.0, 10.2, 0.0, null)
        val dashboardResult = FieldsUtil.getFieldValuePairs(dashboard)


        //Dashboard assertions
        assertEquals("Receiving:", dashboardResult[0].title)
        assertEquals("12.0", dashboardResult[0].content)

        assertEquals("Loading:", dashboardResult[1].title)
        assertEquals("0", dashboardResult[1].content)

        assertEquals("Drying:", dashboardResult[3].title)
        assertEquals("9.0", dashboardResult[3].content)

        assertEquals("Offloading:", dashboardResult[2].title)
        assertEquals("10.2", dashboardResult[2].content)

        assertEquals("Sorting:", dashboardResult[4].title)
        assertEquals("0.0", dashboardResult[4].content)

        assertEquals("Packing:", dashboardResult[5].title)
        assertEquals("0", dashboardResult[5].content)

    }
}