package com.interndemosss.kotlin_dsa_basics

fun main(){
    //Mutable Map
    val  VegitablePrice = mutableMapOf("Potato" to 1.5 , "bengan" to 2.5 , "tomato" to 6.5)

    //updating the price  of tomato
    VegitablePrice["tomato"] = 4.0

    //Adding  new element  to map
    VegitablePrice.put("garlic" , 8.8)

    // print all map  elements
    for ((Key , values) in VegitablePrice){
        println("Vegetables : $Key, price : $values")
    }
}