package com.example.sooloop

import android.content.Context
import android.media.SoundPool

class PlaybackService : PlaybackInterface {
    /**
     * Constants
     */
    private val LOAD_PRIORITY = 1
    private val PLAY_VOLUME_LEFT = 1F
    private val PLAY_VOLUME_RIGHT = 1F
    private val PLAY_PRIORITY = 0

    private val soundPool = SoundPool.Builder()
        .setMaxStreams(8)
        .build()
    private val beatMap = HashMap<Beat, Int>()

    /**
     * Properties
     */
    private var rate: Float = 1F
    private var loop = 0
    private var streamId = 0

    override fun load(context: Context, beat: Beat) {
        if (!beatMap.containsKey(beat)) {
            val soundId = soundPool.load(context, beat.raw(), LOAD_PRIORITY)
            beatMap.put(beat, soundId)
        }
    }

    override fun unload(beat: Beat) {
        val soundId = beatMap[beat]
        if (soundId != null) {
            soundPool.unload(soundId)
        }
    }

    override fun play() {
        beatMap.forEach {
            soundPool.play(it.value,
                PLAY_VOLUME_LEFT, PLAY_VOLUME_RIGHT, PLAY_PRIORITY,
                loop, rate)
        }
    }

    override fun stop() {
        if (0 < streamId) {
            soundPool.stop(streamId)
        }
    }

    override fun pause() {
        soundPool.autoPause()
    }

    override fun resume() {
        soundPool.autoResume()
    }

    override fun setRate(rate: Float) {
        this.rate = rate
    }
}