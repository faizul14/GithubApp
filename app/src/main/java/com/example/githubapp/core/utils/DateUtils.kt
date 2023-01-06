package com.example.githubapp.core.utils

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object DateUtils {

    fun getDateUpdate(pastTimeString: String): String {
        //format 2023-01-05T07:11:50Z
        val currentTimeDumy = 1673046708402
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val pastTimeDate = dateFormat.parse(pastTimeString)
        val pastTime = pastTimeDate.time
        val currentTime = System.currentTimeMillis()
        val timeDifference = currentTimeDumy - pastTime
        val seconds = TimeUnit.MILLISECONDS.toSeconds(timeDifference)
        return getUpdateDetails(seconds.toInt())
    }

    fun getUpdateDetails(time: Int): String {
        var data = ""
        var temp = 0
        if (time > 604800) {
            //minggu
            temp = time / 604800
            data = "$temp weeks ago"
        } else if (time > 86400) {
            //hari
            temp = time / 86400
            data = "$temp day ago"
        } else if (time > 3600) {
            //jam
            temp = time / 3600
            data = "$temp hours ago"
        } else if (time > 60) {
            //menit
            temp = time / 60
            data = "$temp minute ago"
        } else {
            //menit
            temp = time
            data = "$temp seconds ago"
        }
        return data
    }
}