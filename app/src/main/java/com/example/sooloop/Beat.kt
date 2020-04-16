package com.example.sooloop

enum class Beat {
    GUITAR_LEAD_01 {
        override fun raw(): Int {
            return R.raw.guitar_lead
        }
    },

    DRUM_01 {
        override fun raw(): Int {
            return R.raw.drum
        }

    },

    PIANO_LEAD_01 {
        override fun raw(): Int {
            return R.raw.piano_lead
        }
    };

    abstract fun raw(): Int
}