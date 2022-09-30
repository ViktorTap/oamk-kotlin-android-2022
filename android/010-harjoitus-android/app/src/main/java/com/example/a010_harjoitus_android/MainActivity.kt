package com.example.a010_harjoitus_android

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showAlertDialog(view: View) {

        MaterialAlertDialogBuilder(this)
            .setTitle("Alert")
            .setMessage("Do you want to move to the activity 2?")
            .setNegativeButton("No") {dialog, which ->
        Toast.makeText(this, "Declined", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Yes") {dialog, which ->
                callActivity();
            }
            .show()


}

    private fun callActivity(){
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)

    }}



