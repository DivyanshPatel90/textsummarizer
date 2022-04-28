package com.divyansh.textsummarizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        var textButton : AppCompatButton = findViewById(R.id.textBtn);
        var uploadButton : AppCompatButton = findViewById(R.id.uploadBtn);

        textButton.setOnClickListener(View.OnClickListener {

            startActivity(Intent(this,WriteText::class.java));

        })
        uploadButton.setOnClickListener(View.OnClickListener {

            startActivity(Intent(this,UploadFile::class.java));

        })

    }
}