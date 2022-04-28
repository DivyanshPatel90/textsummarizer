package com.divyansh.textsummarizer

import android.R.attr
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import android.R.attr.label

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast


class DisplaySummary : AppCompatActivity() {

    lateinit var tts : TextToSpeech


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_summary)
        var ans : TextView = findViewById(R.id.ans);


        var speech:FloatingActionButton = findViewById(R.id.texttospeech);
        var copy:FloatingActionButton = findViewById(R.id.copy);
        var share:FloatingActionButton = findViewById(R.id.share);




        val intentValue = intent.getStringExtra("summary")

        ans.setText(intentValue.toString());

        speech.setOnClickListener(View.OnClickListener {
             tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                 if(it==TextToSpeech.SUCCESS){
                     tts.language = Locale.US
                     tts.setSpeechRate(1.0f)
                     tts.speak(ans.text.toString(),TextToSpeech.QUEUE_ADD,null)
                 }
             })
        }
        )

        copy.setOnClickListener(View.OnClickListener {
            val clipboard: ClipboardManager =getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("label", ans.text.toString())
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this,"Copied",Toast.LENGTH_SHORT).show()
        })

        share.setOnClickListener(View.OnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, ans.text.toString());
            startActivity(Intent.createChooser(shareIntent,"Share Summary to"))

        })



    }
}