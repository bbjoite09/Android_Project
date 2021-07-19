package com.example.dice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            // toast 메시지
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()

            // 버튼 누를때마다 textView 랜덤하게 변경
            rollDice()
        }
    }

    private fun rollDice() {
        // 6면의 주사위를 랜덤하게 던짐
        val dice = Dice(6)
        val diceRoll = dice.roll()
        
        // 랜덤한 숫자를 textView에 넣기
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

// 랜덤하게 숫자를 뽑아 줌
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}