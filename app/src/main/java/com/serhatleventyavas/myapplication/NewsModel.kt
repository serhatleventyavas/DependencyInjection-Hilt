package com.serhatleventyavas.myapplication

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsModel(
    @Json(name = "title")
    val title: String
)