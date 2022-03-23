package com.example.iphoneclock.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.MutableLiveData
import java.util.*

class StopwatchViewModel:ViewModel() {
    var stopWatchText = MutableLiveData("00:00:00")
    var seconds=0
    var running=false
    var wasRunning=false
    init {
        runTimer()
    }

    fun onClickStart(){
        running=true
        Log.i("Runngin called","haha")
    }
    fun onClickStop(){
        running=false
    }
    fun onClickReset(){
        running=false
        seconds=0
    }
    private fun runTimer(){
        var handler=Handler()
        handler.post(object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = seconds % 3600 / 60
                val secs = seconds % 60

                // Format the seconds into hours, minutes,
                // and seconds.
                val time = String.format(
                    Locale.getDefault(),
                    "%d:%02d:%02d", hours,
                    minutes, secs
                )

                // Set the text view text.
                stopWatchText.value=time
                Log.i("Haha",time)

                // If running is true, increment the
                // seconds variable.
                if (running) {
                    seconds++
                }

                // Post the code again
                // with a delay of 1 second.
                handler.postDelayed(this, 1000)
            }
        })
    }
    }