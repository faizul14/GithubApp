package com.example.githubapp.core.utils

import org.junit.Assert
import org.junit.Test

class DateUtilsTest {

    @Test
    fun `get correct date lastUpdate`() {
        val pastTime = "2023-01-05T07:11:50Z"
        Assert.assertEquals("1 day ago", DateUtils.getDateUpdate(pastTime))
    }

    @Test
    fun `get correct date lastUpdateDetails`() {
        Assert.assertEquals("1 day ago", DateUtils.getUpdateDetails(143998))
    }


}