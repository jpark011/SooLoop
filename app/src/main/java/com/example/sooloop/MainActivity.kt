package com.example.sooloop

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val playbackService = PlaybackService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        playbackSpeed.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                playbackService.setRate(progress / 10f)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        pianoToggle.setOnCheckedChangeListener { _, isChecked ->
            toggleBeat(isChecked, Beat.PIANO_LEAD_01)
        }

        guitarToggle.setOnCheckedChangeListener { _, isChecked ->
            toggleBeat(isChecked, Beat.GUITAR_LEAD_01)
        }

        drumToggle.setOnCheckedChangeListener { _, isChecked ->
            toggleBeat(isChecked, Beat.DRUM_01)
        }
    }

    fun toggleBeat(isChecked: Boolean, beat: Beat) {
        if (isChecked)
            playbackService.load(this, beat)
        else
            playbackService.unload(beat)
    }

    fun playSound(view: View) {
        playbackService.play()
    }
}
