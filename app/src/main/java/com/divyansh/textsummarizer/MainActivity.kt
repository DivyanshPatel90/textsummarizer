package com.divyansh.textsummarizer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.ml.quaterion.text2summary.Text2Summary

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button:Button = findViewById(R.id.startbtn);
        var lottie:LottieAnimationView = findViewById(R.id.lottie);

       button.setOnClickListener(View.OnClickListener {

            startActivity(Intent(this,InputActivity::class.java));

        })
    }

}

