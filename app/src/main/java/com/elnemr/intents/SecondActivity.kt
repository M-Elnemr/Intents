package com.elnemr.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        when(intent.action){
            "openSecondActivity" -> showToast("openSecondActivity")
            Intent.ACTION_VIEW -> showToast(intent.getStringExtra(Intent.EXTRA_TEXT))
            Intent.ACTION_SEND -> {showToast(intent.getStringExtra(Intent.EXTRA_TEXT))}
        }
    }

    private fun showToast(message: String?){
        message?.let {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}