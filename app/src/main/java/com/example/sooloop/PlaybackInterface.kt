package com.example.sooloop

import android.content.Context

interface PlaybackInterface {
    fun load(context: Context, beat: Beat)
    fun unload(beat: Beat)
    fun play()
    fun stop()
    fun pause()
    fun resume()
    fun setRate(rate: Float)
}