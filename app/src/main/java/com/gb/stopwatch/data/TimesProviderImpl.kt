package com.gb.stopwatch.data

import com.gb.stopwatch.domain.repository.TimestampProvider

class TimesProviderImpl : TimestampProvider {
    override fun getMilliseconds(): Long {
        return System.currentTimeMillis()
    }
}