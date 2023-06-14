package com.example.lecture15challenge

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class StoryDetails : AppCompatActivity() {
    lateinit var music : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_details)

        val text : TextView = findViewById(R.id.story_tv)
        val image : ImageView = findViewById(R.id.image_tv)

        title = intent.getStringExtra("title")

        music = MediaPlayer.create(this,intent.getIntExtra("sound",1))
        music.start()


        val img = intent.getIntExtra("picture",0)
        image.setImageResource(img)

        val textPreference = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val textSize = textPreference.getInt("size", 20)

        val story = intent.getStringExtra("story")
        text.text = story.toString()
        text.textSize = textSize.toFloat()



    }

    override fun onPause() {
        super.onPause()
        music.release()
    }
}


