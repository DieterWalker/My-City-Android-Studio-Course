package com.example.myCity

import com.example.mycityandroidstudiocourses.R
import com.example.mycityandroidstudiocourses.data.Category
import com.example.mycityandroidstudiocourses.data.Places
import com.example.mycityandroidstudiocourses.ui.MyCityViewModel
import org.junit.Before
import org.junit.Test
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue


class MyCityViewModelTest {

    @Before
    fun setUp(){
        MyCityTestData.viewModel = MyCityViewModel()
    }

    @Test /*Kiểm tra Category có set đúng state không*/
    fun onCategorySelect_shouldUpdateCurrentPlace(){
        MyCityTestData.viewModel.onCategorySelect(MyCityTestData.testCategory)

        val state = MyCityTestData.viewModel.uiState.value
        assertEquals(MyCityTestData.testCategory, state.currentCategory)
    }

    @Test /*Kiểm tra Place có set đúng state không*/
    fun onPlaceSelect_shouldUpdateCurrentPlace(){
        MyCityTestData.viewModel.onPlaceSelect(MyCityTestData.testPlace)

        val state = MyCityTestData.viewModel.uiState.value
        assertEquals(MyCityTestData.testPlace, state.currentPlace)
    }

    @Test /*Kiểm tra BackStack có reset đúng không*/
    fun onBlackPlacePressed_currentPlaceShouldBeClear(){
        MyCityTestData.viewModel.onPlaceSelect(MyCityTestData.testPlace)
        MyCityTestData.viewModel.onPlaceBack()

        assertNull(MyCityTestData.viewModel.uiState.value.currentPlace)
    }

    @Test
    fun onBlackCategoryPressed_currentPlaceListShouldBeClear(){
        MyCityTestData.viewModel.onCategorySelect(MyCityTestData.testCategory)
        MyCityTestData.viewModel.onCategoryBack()

        assertNull(MyCityTestData.viewModel.uiState.value.currentCategory)
        assertTrue(MyCityTestData.viewModel.uiState.value.placesByCategory.isEmpty())
    }
}