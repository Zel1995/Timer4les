package com.gb.stopwatch.domain.repository

interface TimestampProvider {
    fun getMilliseconds(): Long
}