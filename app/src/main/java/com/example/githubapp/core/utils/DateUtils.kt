package com.example.githubapp.core.utils

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object DateUtils {

    fun getDateUpdate(time: String):String{
        val pastTimeString = "2023-01-05T07:11:50Z"
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val pastTimeDate = dateFormat.parse(pastTimeString)
        val pastTime = pastTimeDate.time
        val currentTime = System.currentTimeMillis()
        val timeDifference = currentTime - pastTime
        val seconds = TimeUnit.MILLISECONDS.toSeconds(timeDifference)
        return seconds.toString()
    }
}