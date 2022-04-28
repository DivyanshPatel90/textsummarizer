package com.divyansh.textsummarizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ml.quaterion.text2summary.Text2Summary

class WriteText : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_text)
        var button: Button = findViewById(R.id.button)
        var text: EditText = findViewById(R.id.text)
        var legnth: EditText = findViewById(R.id.summaryLength)


        button.setOnClickListener {

//            val summary:String = Text2Summary.summarize(s, 0.2F)


                    var lengthfloat:Float = ((legnth.text.toString().toFloat())/100)


                    val callback = object : Text2Summary.SummaryCallback {
                        override fun onSummaryProduced(summary: String) {
                            var i :Intent  = Intent(this@WriteText,DisplaySummary::class.java).apply {
                                putExtra("summary",summary)
                            }
                            startActivity(i);
                        }
                    }

                    Text2Summary.summarizeAsync( text.text.toString() , lengthfloat , callback  )

                }




        }
    }
