package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.TextClock
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    //Intializing TTS
    lateinit var tts:TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSpeak =findViewById<Button>(R.id.btn1)
        var editField = findViewById<EditText>(R.id.textArea)

        //
        tts = TextToSpeech(applicationContext,
            TextToSpeech.OnInitListener
            {
                if(it==TextToSpeech.SUCCESS)
                {
                    tts.setLanguage(Locale.US)
                    tts.setSpeechRate(1.0f)
                }else
            {
                Toast.makeText(this, "Intialization failed!", Toast.LENGTH_SHORT).show()
            }
        })

        //function for event listener
        btnSpeak.setOnClickListener {
            var text=editField.text.toString()
            tts.speak(text, TextToSpeech.QUEUE_ADD, null, null)
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}