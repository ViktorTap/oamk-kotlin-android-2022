package com.example.a011_oma_sovellus_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.math.RoundingMode
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val etKilos = findViewById<EditText>(R.id.editTextNumber);
        val etReps = findViewById<EditText>(R.id.editTextNumber2);
        val btnCalculate = findViewById<Button>(R.id.button2);
        val btnHelp = findViewById<Button>(R.id.btn_help);

        val weight1 = findViewById<TextView>(R.id.tv1Weight);
        val weight2 = findViewById<TextView>(R.id.tv2Weight);
        val weight3 = findViewById<TextView>(R.id.tv3Weight);
        val weight4 = findViewById<TextView>(R.id.tv4Weight);
        val weight5 = findViewById<TextView>(R.id.tv5Weight);
        val weight6 = findViewById<TextView>(R.id.tv6Weight);
        val weight7 = findViewById<TextView>(R.id.tv7Weight);
        val weight8 = findViewById<TextView>(R.id.tv8Weight);
        val weight9 = findViewById<TextView>(R.id.tv9Weight);
        val weight10 = findViewById<TextView>(R.id.tv10Weight);

        var isKilos: Boolean = false
        var isReps: Boolean = false

        btnCalculate.isEnabled = false

        fun toastingKilos () {

                val toast = Toast.makeText(applicationContext, "please enter max 500 to lifted weight", Toast.LENGTH_SHORT)
                toast.show()

            }

        etKilos.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isKilos = !p0.isNullOrEmpty()


            }

            override fun afterTextChanged(p0: Editable?) {
                btnCalculate.isEnabled = isKilos && isReps

            }

        })

        etReps.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isReps = !p0.isNullOrEmpty()


            }

            override fun afterTextChanged(p0: Editable?) {
                btnCalculate.isEnabled = isKilos && isReps
            }

        })

        fun toastingReps(){
            val toast = Toast.makeText(applicationContext, "please enter 1 - 10 reps", Toast.LENGTH_SHORT)
            toast.show()
        }

        btnCalculate.setOnClickListener(){
            val kilos = etKilos.text.toString().toInt()
            val reps = etReps.text.toString().toInt()

            var coff: Float = 0F

            if (kilos > 500) {
                toastingKilos()
                return@setOnClickListener
            }

            when(reps){
                1 -> {
                    coff = 1F
                }
                2 -> {
                    coff = 1.035F
                }
                3 -> {
                    coff = 1.08F
                }
                4 -> {
                    coff = 1.115F
                }
                5 -> {
                    coff = 1.15F
                }
                6 -> {
                    coff = 1.18F
                }
                7 -> {
                    coff = 1.22F
                }
                8 -> {
                    coff = 1.255F
                }
                9 -> {
                    coff = 1.29F
                }
                10 -> {
                    coff = 1.325F
                }
                else -> {
                    coff = 0F
                    toastingReps()

                }

            }


            fun putAllWeight(res: Double){
                weight1.setText(res.toString())

                val weightArr: Array<Double> = arrayOf(0.95, 0.9, 0.85, 0.8, 0.75, 0.7, 0.65, 0.6, 0.55)
                val weightSegArr = arrayOf(weight2, weight3, weight4, weight5, weight6, weight7, weight8, weight9, weight10)

                var x: Int = 0

                for (i in weightArr) {
                    val result = i * res
                    val z = result.roundToInt()
                    val y = z % 2.5
                    if (y <= 1.5) {
                        val c = (z - y).toBigDecimal().setScale(1, RoundingMode.HALF_EVEN).toDouble()
                        weightSegArr[x].setText(c.toString())
                    } else {
                        val c = (z + 0.5).toBigDecimal().setScale(1, RoundingMode.HALF_EVEN).toDouble()
                        weightSegArr[x].setText(c.toString())
                    }
                    x += 1
                }

            }

            val result1 = kilos * coff
            val x = result1.roundToInt()
            val y = x % 2.5
            if (y <= 1.5) {
                val c = x - y
                putAllWeight(c)
            } else {
                val c = x + 0.5
                putAllWeight(c)
            }



        }

        btnHelp.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("HELP WINDOW")
            builder.setMessage("Enter lifted weight(kg) in LIFT and repetitions in REPS. " +
                    "Be aware that the weight is approximate.")
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            builder.setNeutralButton("Roger That"){dialogInterface, which ->
                Toast.makeText(applicationContext, "Alrighty!", Toast.LENGTH_LONG).show()
            }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()

        }





    }


}
