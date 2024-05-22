package com.example.speech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

lateinit var tts : TextToSpeech
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)
        var editTextField = findViewById<EditText>(R.id.textArea)

        tts = TextToSpeech(applicationContext,TextToSpeech.OnInitListener {
            if(it == TextToSpeech.SUCCESS)
            {
                tts.setLanguage(Locale.US)
                tts.setSpeechRate(1.0f)            }
            else{
                Toast.makeText(this, "Initialization Failed!", Toast.LENGTH_SHORT).show()
            }
        })

        button.setOnClickListener {
            var text = editTextField.text.toString()
            tts.speak(text, TextToSpeech.QUEUE_ADD,null,null)
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}