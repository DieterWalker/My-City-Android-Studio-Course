package com.example.mycityandroidstudiocourses.data

import androidx.annotation.StringRes
import com.example.mycityandroidstudiocourses.R

@StringRes
fun Category.displayNameRes(): Int {
    return when(this) {
        Category.Cafe -> R.string.category_coffee
        Category.Restaurant -> R.string.category_restaurant
        Category.Park -> R.string.category_park
        Category.Mall -> R.string.category_mall
    }
}
