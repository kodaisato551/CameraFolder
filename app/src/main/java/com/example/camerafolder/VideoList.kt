package com.example.camerafolder

import android.net.Uri
import java.text.SimpleDateFormat
import java.util.*

object VideoList {
    data class Entry(val fileName: String, val fileUri: Uri)

    // val videos = mutableListOf<Entry>()

    private val videoMap = mutableMapOf<String, Uri>()

    fun add(fileUri: Uri) {
        this.add(getCurrentTime(), fileUri)
    }

    fun add(fileName: String, fileUri: Uri) {
        //videos.add(Entry(fileName, fileUri))
        videoMap.put(fileName, fileUri)
    }

    fun getMap(): MutableMap<String, Uri> {
        return videoMap
    }

    private fun getCurrentTime(): String {
        val date = Date()
        val format = SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault())
        return format.format(date)
    }

}