package com.interndemosss.kotlin_dsa_basics

fun main() {
    //  List : Ordered Collection in which We can access elements by
    //  using indices that define a position  for each elements

    // Immutable : read -only list
    val Names = listOf("Rutik","Yash","Mihir")

    //Accessing the elements of Immutable list
    for (item in Names){
        println(item)
    }
}