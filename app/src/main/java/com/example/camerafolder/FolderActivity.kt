package com.example.camerafolder

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.folder_activity.*

@SuppressLint("Registered")
class FolderActivity : AppCompatActivity(), AdapterView.OnItemClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.folder_activity)

        videoList.setOnItemClickListener(this)

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_expandable_list_item_1,
            VideoList.getMap().keys.toMutableList()
        )

        backButton.setOnClickListener {
            val backIntent = Intent(application, MainActivity::class.java)
            startActivity(backIntent)
        }
        videoList.adapter = adapter
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
////        super.onActivityResult(requestCode, resultCode, data)
////        if (resultCode == Activity.RESULT_OK && requestCode == Const.TO_FOLDER) {
////            Log.d("FolderActivity", "called")
////        }
////    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val previewIntent = Intent(application, PreviewActivity::class.java)
        val name = VideoList.getMap().keys.toList()[position]
        Log.d("FolderActivity", "$name is selected")
        previewIntent.putExtra("fileName", name)
        startActivity(previewIntent)
    }
}