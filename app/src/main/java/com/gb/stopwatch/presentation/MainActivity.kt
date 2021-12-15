package com.gb.stopwatch.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gb.stopwatch.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val model by viewModel<StopwatchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_time)
        CoroutineScope(
            Dispatchers.Main
                    + SupervisorJob()
        ).launch {
            model.ticker.collect {
                textView.text = it
            }
        }

        findViewById<Button>(R.id.button_start).setOnClickListener {
            model.start()
        }
        findViewById<Button>(R.id.button_pause).setOnClickListener {
            model.pause()
        }
        findViewById<Button>(R.id.button_stop).setOnClickListener {
            model.stop()
        }

    }
}

