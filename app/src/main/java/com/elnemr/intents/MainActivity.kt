package com.elnemr.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_second_activity_explicit).setOnClickListener {
            startActivityExplicitIntent()
        }

        findViewById<Button>(R.id.btn_second_activity_implicit).setOnClickListener {
            startActivityImplicitIntent()
        }

        findViewById<Button>(R.id.btn_view_webpage).setOnClickListener {
            viewWebpage()
        }

        findViewById<Button>(R.id.btn_share_text).setOnClickListener {
            shareTextIntent()
        }

    }

    // Explicit Intent
    private fun startActivityExplicitIntent() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    // Implicit Intent -- with a custom action
    private fun startActivityImplicitIntent() {
        val intent = Intent("openSecondActivity")
        startActivity(intent)
    }

    private fun viewWebpage() {
        val uri = Uri.parse("http://www.google.com")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    //share intent
    private fun shareTextIntent() {
        var text = "shared text"
        findViewById<EditText>(R.id.et_text).text.toString().let {
            if (it.isNotEmpty()) text = it
        }
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, text)
        intent.type = "text/plain"
        startActivity(intent)
    }

    private fun shareImageIntent() {
        var imagePath = "path"

        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_STREAM, imagePath)
        intent.type = "image/*"
        startActivity(intent)
    }

}