package com.divyansh.textsummarizer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class UploadFile : AppCompatActivity() {

    lateinit var demo:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_file)
        var uploadbtn : ImageView = findViewById(R.id.uploadBtn)
        var summarybtn :Button = findViewById(R.id.summarizeBtn)
        demo = findViewById(R.id.demo)

        uploadbtn.setOnClickListener(View.OnClickListener {
            var intent:Intent = Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            startActivityForResult(intent,10)
        })
    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        when(resultCode ){
            10->
                if(resultCode== RESULT_OK){

                    val path: String? = data?.data?.path
                    demo.setText(path)
                    Toast.makeText(this,path, LENGTH_LONG).show()

//                    val bufferedReader: BufferedReader = File( "poems.txt" ).bufferedReader()
//                    val text = bufferedReader.use{ it.readText() }
//                    val summary = Text2Summary.summarize( text , 0.7F )

                }
        }
    }
}