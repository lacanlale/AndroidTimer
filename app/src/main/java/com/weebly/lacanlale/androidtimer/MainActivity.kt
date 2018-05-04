package com.weebly.lacanlale.androidtimer

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab_play.setOnClickListener { view ->
            Toast.makeText(applicationContext, ":･ﾟ☆✧ STARTING ✧☆ﾟ･:", Toast.LENGTH_SHORT).show()
        }
        fab_pause.setOnClickListener { _ ->
            Toast.makeText(applicationContext, ":･ﾟ☆✧ PAUSING ✧☆ﾟ･:", Toast.LENGTH_SHORT).show()
        }
        fab_stop.setOnClickListener { view ->
            Toast.makeText(applicationContext, ":･ﾟ☆✧ STOPPING ✧☆ﾟ･:", Toast.LENGTH_SHORT).show()
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
}
