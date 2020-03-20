package com.cafrecode.lib.am2v

import junit.framework.Assert.assertEquals
import org.junit.Test


internal class FieldsUtilTest {

    @Test
    fun getFieldValuePairs() {

        val consignment = Consignment("1", "Ndumaa")
        val results = FieldsUtil.getFieldValuePairs(consignment)

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

        assertEquals("S 0:", packagingResult[3].title)
        assertEquals("09 Kgs", packagingResult[3].content)

        assertEquals("S 1s:", packagingResult[4].title)
        assertEquals("34 Kgs", packagingResult[4].content)

    }
}