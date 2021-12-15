package com.gb.stopwatch.di

import com.gb.stopwatch.presentation.StopwatchStateCalculator
import com.gb.stopwatch.data.TimesProviderImpl
import com.gb.stopwatch.domain.repository.TimestampProvider
import com.gb.stopwatch.domain.usecases.ElapsedTimeCalculator
import com.gb.stopwatch.presentation.StopwatchStateHolder
import com.gb.stopwatch.presentation.StopwatchViewModel
import com.gb.stopwatch.presentation.formatter.TimestampMillisecondsFormatter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModules = module {

    viewModel { StopwatchViewModel(stopwatchStateHolder = get()) }

    factory {
        StopwatchStateHolder(
            stopwatchStateCalculator = get(),
            elapsedTimeCalculator = get(),
            timestampMillisecondsFormatter = get()
        )
    }

    factory { StopwatchStateCalculator(timestampProvider = get(), elapsedTimeCalculator = get()) }

    factory<TimestampProvider> { TimesProviderImpl() }

    factory { ElapsedTimeCalculator(timestampProvider = get()) }

    factory { TimestampMillisecondsFormatter() }


}