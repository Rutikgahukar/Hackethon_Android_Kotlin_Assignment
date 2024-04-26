package com.interndemosss.kotlin_dsa_basics
 fun main(){
     // Immutable Map : Map is an Object  that maps Keys to value
     // Map keys are Unique
     // Map Values can be duplicates

  // Immutable Maps
  val fruits = mapOf("apple" to 5 ,"Banana" to 2 , "Orange" to 6)

  // Accessing the Map elements
  val  quantityOfBanan = fruits["Banana"]
  println("The Quantity of Banana : $quantityOfBanan")
}