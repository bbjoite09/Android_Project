package com.example.dice


fun main() {
    val myFirstDice = DiceRoll(6)
    val rollResult = myFirstDice.roll()
    println("Your ${myFirstDice.numSides} sided dice rolled ${rollResult}!")

    val luckyNumber = 4

    when(rollResult){
        luckyNumber -> println("You win!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        else -> println("Apologies! you rolled a 6. Try again!")
    }
}

class DiceRoll(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}