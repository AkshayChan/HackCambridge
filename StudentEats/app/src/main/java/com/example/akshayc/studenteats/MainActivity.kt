package com.example.akshayc.studenteats

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startPreferencesActivity(view: View): Unit {
        val intent = Intent(this, PreferencesActivity::class.java)
        startActivity(intent)
    }

}
