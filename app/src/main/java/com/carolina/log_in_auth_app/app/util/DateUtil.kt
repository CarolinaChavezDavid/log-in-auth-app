package com.carolina.log_in_auth_app.app.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class DateUtil {
    companion object {
        fun getTodayDate(): CharSequence? {
            val c: Date = Calendar.getInstance().getTime()
            val df = SimpleDateFormat("EEEE,MMMM dd", Locale.getDefault())
            return df.format(c)
        }
    }
}
