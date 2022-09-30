package com.example.a007_harjoitus_android

import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private var mp: MediaPlayer? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageBear = findViewById<ImageView>(R.id.imageBear);
        val imageWolf = findViewById<ImageView>(R.id.imageWolf);
        val imageElephant = findViewById<ImageView>(R.id.imageElephant);
        val imageLamb = findViewById<ImageView>(R.id.imageLamb);

        fun onClickBear() {
            mp = MediaPlayer.create(this, R.raw.bear)
            mp!!.start();
        }

        fun onClickWolf() {
            mp = MediaPlayer.create(this, R.raw.wolf)
            mp!!.start();
        }

        fun onClickElephant() {
            mp = MediaPlayer.create(this, R.raw.elephant)
            mp!!.start();
        }

        fun onClickLamb() {
            mp = MediaPlayer.create(this, R.raw.lamb)
            mp!!.start();
        }

        imageBear.setOnClickListener{
            onClickBear();
        }
        imageWolf.setOnClickListener{
            onClickWolf();
        }
        imageElephant.setOnClickListener{
            onClickElephant();
        }
        imageLamb.setOnClickListener{
            onClickLamb();
        }
    }


}