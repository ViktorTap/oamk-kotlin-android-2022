package com.example.a008_harjoitus_fragmentointi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a008_harjoitus_fragmentointi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, BlankFragment.newInstance())
                .commit()
        }

        binding.button2.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, BlankFragment2.newInstance())
                .commit()
        }

    }


}