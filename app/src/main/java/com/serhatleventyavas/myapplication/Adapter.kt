package com.serhatleventyavas.myapplication

import javax.inject.Inject

class Adapter @Inject constructor(
    private val repository: Repository
) {
    fun load() {
        repository.load()
    }
}