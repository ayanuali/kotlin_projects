package com.ayanuali.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roll_button: Button = findViewById(R.id.roll_button)
//        roll_button.setText("Lets roll")
        roll_button.setOnClickListener {
//            Toast.makeText(this, "Button clicked" , Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.setText("dice rolled")
        val randonInt = Random.nextInt(1, 7)
        resultText.text = randonInt.toString()

    }
}