package com.ayanuali.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.setText("dice rolled")
        val randomInt = Random.nextInt(1, 7)
//        resultText.text = randonInt.toString()
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val diceImage: ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResource)

    }
}