package com.example.lecture15challenge

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        title = "Settings"


        val rd: RadioGroup = findViewById(R.id.rg)

        val pref = getSharedPreferences("Settings", MODE_PRIVATE)
        val savedSize = pref.getInt("size", 24)
        when (savedSize) {
            20 -> rd.check(R.id.small_rb)
            30 -> rd.check(R.id.medium_rb)
            40 -> rd.check(R.id.large_rb)
        }
        rd.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.small_rb -> saveTextSize(20)
                R.id.medium_rb -> saveTextSize(30)
                R.id.large_rb -> saveTextSize(40)

            }
        }

    }
    fun saveTextSize(size: Int) {
        val editor = getSharedPreferences("settings", Context.MODE_PRIVATE).edit()
        editor.putInt("size", size)
        editor.apply()
        Toast.makeText(this, "Size Changed Successfully", Toast.LENGTH_SHORT).show()
    }
}