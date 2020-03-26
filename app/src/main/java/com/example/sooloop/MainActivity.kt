package com.example.sooloop

import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val start_button = findViewById<Button>(R.id.startButton)
    private val soundPool = SoundPool(4, AudioManager.STREAM_MUSIC, 0);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        start_button.setOnClickListener({
            
        })
    }
}
