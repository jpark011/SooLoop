package com.example.sooloop

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val soundPool = SoundPool.Builder()
        .setMaxStreams(8)
        .build()
    private var i: Int = 0
    private var iB: Boolean = false
    private var j: Int = 0
    private var jB: Boolean = false
    private var k: Int = 0
    private var kB: Boolean = false
    private var player: Int = 0
    private var playbackRate: Float = 1f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        playbackSpeed.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                playbackRate = progress / 10f
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        pianoToggle.setOnCheckedChangeListener { _, isChecked ->
            kB = isChecked
        }

        guitarToggle.setOnCheckedChangeListener { _, isChecked ->
            iB = isChecked
        }

        drumToggle.setOnCheckedChangeListener { _, isChecked ->
            jB = isChecked
        }


        i = soundPool.load(this, R.raw.guitar_lead, 1)
        j = soundPool.load(this, R.raw.drum , 1)
        k = soundPool.load(this, R.raw.piano_lead , 1)
    }

    fun playSound(view: View) {
        if (iB) soundPool.play(i, 1F, 1F, 0, 0, playbackRate)
        if (jB) soundPool.play(j, 1F, 1F, 0, 0, playbackRate)
        if (kB) soundPool.play(k, 1F, 1F, 0, 0, playbackRate)
    }
}
