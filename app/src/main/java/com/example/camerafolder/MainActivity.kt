package com.example.camerafolder

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recordButton.setOnClickListener {
            val callVideoAppIntent: Intent = Intent()
            callVideoAppIntent.action = MediaStore.ACTION_VIDEO_CAPTURE
            startActivityForResult(callVideoAppIntent, Const.ACTIVITY_START_CAMERA_APP)
        }
        playButton.setOnClickListener {
            videoView.start()
        }

        toFolderButton.setOnClickListener {
            val callToFolderIntent = Intent(application, FolderActivity::class.java)
            startActivity(callToFolderIntent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Const.ACTIVITY_START_CAMERA_APP && resultCode == Activity.RESULT_OK) {
            val videoUri: Uri = data?.data ?: throw IllegalArgumentException()
            Log.d("videoUri", "Url = " + videoUri);
            videoView.setVideoURI(videoUri)
            VideoList.add(videoUri)
        }
    }
}
