package com.example.unit01

fun main() {
    val age = 24
    val name = "Heeeon"
    val border = "`-._,-'"
    val timesToRepeat = 4
    printBorder(border, timesToRepeat)
    print("Happy Birthday!\n")
    println(name)
    println("You are ${age}!")

    createMessage("heeeon", "Seoul", age)
    printBorder("`-._,-'", 4)

    println()

    // Let's print a cake!
    println("   ,,,,,   ")
    println("   |||||   ")
    println(" =========")
    println("@@@@@@@@@@@")
    println("{~@~@~@~@~}")
    println("@@@@@@@@@@@")
    println("")

    printCakeCandles(age)
    printCakeTop(age)
    printCakeBottom(age, 5)

    println("You are already ${age}!")
    println("${age} is the very best age to celebrate!")
}

fun createMessage(name: String, location: String, age: Int) {
    println("My name is ${name}. I am from ${location}, and I am ${age} years old.")
}

fun printBorder(border: String, timesToRepeat: Int) {
    repeat(timesToRepeat) {
        print(border)
    }
    println()
}

fun printCakeTop(age: Int){
    repeat(age+2){
        print("=")
    }
    println()
}

fun printCakeCandles(age: Int){
    print(" ")
    repeat(age){
        print(",")
    }
    println()
    print(" ")
    repeat(age){
        print("|")
    }
    println()
}

fun printCakeBottom(age: Int, layers:Int){
    repeat(layers) {
        repeat(age + 2) {
            print("@")
        }
        println()
    }
}