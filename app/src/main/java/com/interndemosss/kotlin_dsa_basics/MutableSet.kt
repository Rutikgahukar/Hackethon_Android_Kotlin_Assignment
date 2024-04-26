package com.interndemosss.kotlin_dsa_basics

fun  main(){

    //Mutable  Sets : Support both read and write functionality
    val fruits = mutableSetOf("Apple","Banana","Cherry")
    // Addling element to set
    fruits.add("Orange")
    fruits.add("Chiku")
    fruits.remove("Banana")


    for (item in fruits){
        println(item)
    }
}