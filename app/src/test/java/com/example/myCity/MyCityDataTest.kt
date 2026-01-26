package com.example.myCity

import org.junit.Test
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
class MyCityDataTest {
    @Test /*Kiểm tra dữ liệu có được mapping đúng hay không*/
    fun placeList_shouldMapCorrectCategory(){
        assertEquals(MyCityTestData.testCategory, MyCityTestData.testPlace.category)
    }

    @Test
    fun placeList_ListElementShouldNotBeZero(){
        listOf(
            MyCityTestData.testPlace.nameRes,
            MyCityTestData.testPlace.addressRes,
            MyCityTestData.testPlace.imageRes,
            MyCityTestData.testPlace.informationRes,
            MyCityTestData.testPlace.linkRes,
        ).forEach {
            assertTrue(it != 0)
        }
    }
}