package com.interndemosss.kotlin_dsa_basics

fun  main(){
    // Mutable List : Mutable List Are Supports Both Read and Write functionalities
    val  Names = mutableListOf("Rutik","Yash","Mihir")
    // Add element
    Names.add("Vassu")
    //Removing element
    Names.removeAt(0)
    // Update the Value of index
    Names[2] = "Nirmal"

    // print ALl elements of list here
    for (item in Names){
        println(item)
    }

}