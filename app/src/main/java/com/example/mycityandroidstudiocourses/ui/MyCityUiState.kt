package com.example.mycityandroidstudiocourses.ui

import com.example.mycityandroidstudiocourses.data.Category
import com.example.mycityandroidstudiocourses.data.Places

data class MyCityUiState (
    val currentCategory: Category? = null,
    val placesByCategory: List<Places> = emptyList()
)