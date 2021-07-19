package com.example.dice

fun main(){
    val myFirstDice = Dice()
//    println(myFirstDice.sides)
    val diceRoll = myFirstDice.roll()
    println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}!")
}
class Dice {
    var sides = 6

    fun roll(): Int{
        val randomNumber = (1..sides).random()
//        println(randomNumber)
        return randomNumber
    }

}