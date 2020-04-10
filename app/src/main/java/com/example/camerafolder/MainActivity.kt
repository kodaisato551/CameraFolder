package com.example.camerafolder

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val ACTIVITY_START_CAMERA_APP = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recordButton.setOnClickListener {
            val callVideoAppIntent: Intent = Intent()
            callVideoAppIntent.action = MediaStore.ACTION_VIDEO_CAPTURE
            startActivityForResult(callVideoAppIntent, ACTIVITY_START_CAMERA_APP)
        }
        playButton.setOnClickListener {
            videoView.start()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ACTIVITY_START_CAMERA_APP && resultCode == Activity.RESULT_OK) {
            val videoUri: Uri = data?.data ?: throw IllegalArgumentException()
            videoView.setVideoURI(videoUri)
        }
    }
}
