package com.serhatleventyavas.myapplication

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class FirstViewModel @ViewModelInject constructor(
    private val adapter: Adapter,
    private val restAPI: RestAPI
): ViewModel() {

    fun loadViewModel() {
        adapter.load()
    }
}