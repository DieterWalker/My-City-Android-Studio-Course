package com.example.mycityandroidstudiocourses.ui

import androidx.lifecycle.ViewModel
import com.example.mycityandroidstudiocourses.data.Category
import com.example.mycityandroidstudiocourses.data.local.LocalPlaceDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState

    private val allPlaces = LocalPlaceDataProvider. allPlaces

    fun onCategorySelect(category: Category){
        val filtered = allPlaces.filter {it.category == category}

        _uiState.update {
            it.copy(
                currentCategory = category,
                placesByCategory = filtered
            )
        }
    }

}