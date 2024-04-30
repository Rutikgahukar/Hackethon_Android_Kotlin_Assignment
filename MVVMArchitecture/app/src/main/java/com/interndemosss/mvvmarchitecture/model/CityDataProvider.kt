package com.interndemosss.mvvmarchitecture.model

import com.interndemosss.mvvmarchitecture.R

class cityDataProvider {

    private val cities = arrayListOf<City>()

    init {
        cities.add(City("Bangkok", R.drawable.bangkok, 10000000))
        cities.add(City("Beijing", R.drawable.beijing, 21500000))
        cities.add(City("London", R.drawable.london, 80900000))
        cities.add(City("New York", R.drawable.newyork, 70200000))
        cities.add(City("Paris", R.drawable.paris, 20900000))
        cities.add(City("Rio de Janeiro", R.drawable.rio, 40300000))
        cities.add(City("Rome", R.drawable.rome, 20220000))
        cities.add(City("Singapore", R.drawable.singapore, 60220000))
        cities.add(City("Sydney", R.drawable.sydney, 30230000))
        cities.add(City("Tokyo", R.drawable.tokyo, 70689000))
    }

    fun getCities() = cities
}