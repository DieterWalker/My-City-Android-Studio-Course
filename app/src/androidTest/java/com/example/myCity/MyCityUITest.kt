package com.example.myCity

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.mycityandroidstudiocourses.MainActivity
import org.junit.Rule
import org.junit.Test

class MyCityUITest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test /*Kiểm tra màn hinhf chính có hiển thị danh mục không*/
    fun openHomeScreen_ShowCategory(){
        composeTestRule
            .onNodeWithText("NHÀ HÀNG")
            .assertIsDisplayed()
    }

    @Test /*Kiểm tra màn hình có hiện thị địa danh không*/
    fun clickCategoryButton_navigateToPlaces(){
        composeTestRule
            .onNodeWithText("CÔNG VIÊN")
            .performClick()

        composeTestRule
            .onNodeWithText("CÔNG VIÊN")
            .assertIsDisplayed()
    }

    @Test /*Kiểm tra màn hình có hiện thị thông*/
    fun clickPlaceButton_navigateToPlaceInformation(){
        composeTestRule
            .onNodeWithText("TRUNG TÂM THƯƠNG MẠI")
            .performClick()

        composeTestRule
            .onNodeWithText("LANKMART 81")
            .performClick()

        composeTestRule
            .onNodeWithText("LANKMART 81")
            .assertIsDisplayed()
    }
}
