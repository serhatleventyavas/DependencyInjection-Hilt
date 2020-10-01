package com.serhatleventyavas.myapplication

import android.util.Log
import javax.inject.Inject

class Repository @Inject constructor(
    private val restAPI: RestAPI
) {
    fun load() {
        Log.i("Dependency Injection", "Repository is Loaded")
    }
}