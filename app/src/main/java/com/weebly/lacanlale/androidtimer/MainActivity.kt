package com.weebly.lacanlale.androidtimer

import android.os.Bundle
import android.os.CountDownTimer
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast

/**
 * Simple Timer app for all your timing needs!
 */
class MainActivity : AppCompatActivity() {
    private lateinit var timer: CountDownTimer
    private lateinit var fabPause: FloatingActionButton
    private lateinit var fabPlay: FloatingActionButton
    private lateinit var fabStop: FloatingActionButton
    private lateinit var time: TextView

    /** DEFAULT OF 1 MINUTE **/
    private var timeLength = 6000L
    private var timerState = TimerState.Stopped
    private val numFormat = "%.2f"

    enum class TimerState {
        Stopped, Paused, Running
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setIcon(R.drawable.ic_timer)
        supportActionBar?.title = "\t\t\t:･ﾟ☆✧*⏰TIMER⏰*✧☆ﾟ･:"

        fabPause = findViewById(R.id.fab_pause)
        fabPlay = findViewById(R.id.fab_play)
        fabStop = findViewById(R.id.fab_stop)
        time = findViewById(R.id.tv_timer)

        time.text = getString(R.string.timer, (timeLength / 60000L).toString(), "00", "00")

        fabPause.setOnClickListener { _ ->
            Toast.makeText(applicationContext, ":･ﾟ☆✧* PAUSING *✧☆ﾟ･:", Toast.LENGTH_SHORT).show()
            timerState = TimerState.Paused
            updateButtons()
            pause()
            Log.d("TIMER_STATE", "State: $timerState")
        }
        fabPlay.setOnClickListener { _ ->
            Toast.makeText(applicationContext, ":･ﾟ☆✧* STARTING *✧☆ﾟ･:", Toast.LENGTH_SHORT).show()
            timerState = TimerState.Running
            updateButtons()
            begin()
            Log.d("TIMER_STATE", "State: $timerState")
        }
        fabStop.setOnClickListener { _ ->
            Toast.makeText(applicationContext, ":･ﾟ☆✧* STOPPING *✧☆ﾟ･:", Toast.LENGTH_SHORT).show()
            timerState = TimerState.Stopped
            updateButtons()
            stop()
            Log.d("TIMER_STATE", "State: $timerState")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateButtons() {
        when (timerState) {
            TimerState.Running -> {
                fabPlay.isEnabled = false
                fabPause.isEnabled = true
                fabStop.isEnabled = true
            }
            TimerState.Stopped -> {
                fabPlay.isEnabled = true
                fabPause.isEnabled = false
                fabStop.isEnabled = false
            }
            TimerState.Paused -> {
                fabPlay.isEnabled = true
                fabPause.isEnabled = false
                fabStop.isEnabled = true
            }
        }
    }

    private fun begin() {
        timer = object : CountDownTimer(timeLength, 1000) {
            override fun onTick(millisRemaining: Long) {
                Log.d("TIMER_INFO", """
                    |=======================================
                    |~=*!TIME REPORT!*=~
                    |Time remaining: ${millisRemaining / 60000L}
                    |Minutes Elapsed: ${(timeLength - (millisRemaining / 60000L)).toInt()}
                    |Seconds Elapsed: ${(timeLength - ((millisRemaining % 60000L) / 1000)).toInt()}
                    |Milliseconds Elapsed: ${timeLength - millisRemaining}
                    |=======================================
                    """.trimMargin())
                //todo update ui
            }

            override fun onFinish() {
                //notify()
                Toast.makeText(applicationContext, "Your time has come to an end! >:^)", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    private fun stop() {
        //todo finish
    }

    private fun pause() {
        //todo finish
    }
}
