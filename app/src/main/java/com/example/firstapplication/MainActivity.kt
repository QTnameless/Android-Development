package com.example.firstapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButtonMA: Button = findViewById(R.id.button_AM)
        val diceImage: ImageView = findViewById(R.id.imageView)

        rollButtonMA.setOnClickListener {
            rollDiceMA(diceImage)
        }
    }

    private fun rollDiceMA(diceImage: ImageView) {
        val diceMA = DiceMA(6)
        val cubeRoll = diceMA.rollMA()

        // Update the dice image based on the roll
        val drawableResource = when (cubeRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }

    class DiceMA(val numSideMA: Int) {
        fun rollMA(): Int {
            return (1..numSideMA).random()
        }
    }
}
