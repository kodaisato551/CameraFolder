package com.example.camerafolder

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.preview_activity.*

class PreviewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.preview_activity)

        val name = intent.getStringExtra("fileName")
        val pass: Uri = VideoList.getMap()[name] ?: throw IllegalArgumentException()
        videoPreview.setVideoURI(pass)
        videoPreview.start()
    }
}