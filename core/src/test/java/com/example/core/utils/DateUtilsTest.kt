package com.example.core.utils

import com.example.core.utils.DateUtils
import org.junit.Assert
import org.junit.Test

class DateUtilsTest {

    @Test
    fun `get correct date lastUpdate`() {
        val pastTime = "2023-01-05T07:11:50Z"
        Assert.assertNotNull(DateUtils.getDateUpdate(pastTime))
    }

    @Test
    fun `get correct date lastUpdateDetails`() {
        Assert.assertEquals("1 day ago", DateUtils.getUpdateDetails(143998))
    }


}