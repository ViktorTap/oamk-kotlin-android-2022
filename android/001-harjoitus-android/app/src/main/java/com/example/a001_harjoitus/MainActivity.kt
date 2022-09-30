package com.example.a001_harjoitus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            // Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show();
            callActivity()
        }
    }

    private fun callActivity() {
        val etNameText = findViewById<EditText>(R.id.etNameText)
        val name = etNameText.text.toString()

        val intent = Intent(this, MainActivity2::class.java).also {
            it.putExtra("USER_NAME",name)
            startActivity(it)
        }
    }


}