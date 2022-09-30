package com.example.a003_harjoitus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        button1.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.oamk.fi")
            startActivity(openURL)
        }

        button2.setOnClickListener{
            val coordinatesUri = Uri.parse("geo:65.0611844,25.463163?z=15")
            // muokkasin koordinatit oulu amkiin
            val openCoordinates = Intent(Intent.ACTION_VIEW, coordinatesUri)
            openCoordinates.setPackage("com.google.android.apps.maps")
            startActivity(openCoordinates)
        }

        button3.setOnClickListener{
            val placeUri = Uri.parse("geo:0,0?q=bauhaus oulu")
            val mapIntent = Intent(Intent.ACTION_VIEW, placeUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent);
        }
    }
}