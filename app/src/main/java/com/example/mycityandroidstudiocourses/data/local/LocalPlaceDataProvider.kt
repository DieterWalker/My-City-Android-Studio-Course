package com.example.mycityandroidstudiocourses.data.local

import com.example.mycityandroidstudiocourses.R
import com.example.mycityandroidstudiocourses.data.Category
import com.example.mycityandroidstudiocourses.data.Places

object LocalPlaceDataProvider {
    val allPlaces = listOf (
        /* HIGHLANDS COFFEE */
        Places(
            imageRes = R.drawable.highland,
            nameRes = R.string.coffee_1_name,
            addressRes = R.string.coffee_1_address,
            informationRes = R.string.coffee_1_information,
            category = Category.Cafe,
        ),
        /* KATINAT */
        Places(
            imageRes = R.drawable.katinat,
            nameRes = R.string.coffee_2_name,
            addressRes = R.string.coffee_2_address,
            informationRes = R.string.coffee_2_information,
            category = Category.Cafe,
        ),
        /* THE HOUSE COFFEE */
        Places(
            imageRes = R.drawable.thehousecoffee,
            nameRes = R.string.coffee_3_name,
            addressRes = R.string.coffee_3_address,
            informationRes = R.string.coffee_3_information,
            category = Category.Cafe,
        ),
        /* KAI COFFEE */
        Places(
            imageRes = R.drawable.kaicoffee,
            nameRes = R.string.coffee_4_name,
            addressRes = R.string.coffee_2_address,
            informationRes = R.string.coffee_2_information,
            category = Category.Cafe,
        ),

        /* LA BRASSERIE RESTAURANT */
        Places(
            imageRes = R.drawable.labrasserie,
            nameRes = R.string.restaurant_1_name,
            addressRes = R.string.restaurant_1_address,
            informationRes = R.string.restaurant_1_information,
            category = Category.Restaurant,
        ),
        /* BENTHANH PRINCESS */
        Places(
            imageRes = R.drawable.duthuyen,
            nameRes = R.string.restaurant_2_name,
            addressRes = R.string.restaurant_2_address,
            informationRes = R.string.restaurant_2_information,
            category = Category.Restaurant,
        ),
        /* PHO 79 RESTAURANT */
        Places(
            imageRes = R.drawable.pho79,
            nameRes = R.string.restaurant_3_name,
            addressRes = R.string.restaurant_3_address,
            informationRes = R.string.restaurant_3_information,
            category = Category.Restaurant,
        ),

        /* SAIGON RIVERSIDE PARK */
        Places(
            imageRes = R.drawable.thuthiem,
            nameRes = R.string.park_1_name,
            addressRes = R.string.park_1_address,
            informationRes = R.string.park_1_information,
            category = Category.Park,
        ),
        /* DAM SEN WATER PARK */
        Places(
            imageRes = R.drawable.damsen,
            nameRes = R.string.park_2_name,
            addressRes = R.string.park_2_address,
            informationRes = R.string.park_2_information,
            category = Category.Park,
        ),
        /* SUOI TIEN CULTURAL THEME PARK */
        Places(
            imageRes = R.drawable.suoitien,
            nameRes = R.string.park_3_name,
            addressRes = R.string.park_3_address,
            informationRes = R.string.park_3_information,
            category = Category.Park,
        ),
        /* SAIGON ZOO AND BOTANICAL GARDENS */
        Places(
            imageRes = R.drawable.thaocamvien,
            nameRes = R.string.park_4_name,
            addressRes = R.string.park_4_address,
            informationRes = R.string.park_4_information,
            category = Category.Park,
        ),

        /* LANDMARK 81 */
        Places(
            imageRes = R.drawable.landmark,
            nameRes = R.string.mall_1_name,
            addressRes = R.string.mall_1_address,
            informationRes = R.string.mall_1_information,
            category = Category.Mall,
        ),
        /* BITEXCO TOWER */
        Places(
            imageRes = R.drawable.bitexco,
            nameRes = R.string.mall_2_name,
            addressRes = R.string.mall_2_address,
            informationRes = R.string.mall_2_information,
            category = Category.Mall,
        ),
        /* GIGAMALL */
        Places(
            imageRes = R.drawable.gigamall,
            nameRes = R.string.mall_3_name,
            addressRes = R.string.mall_3_address,
            informationRes = R.string.mall_3_information,
            category = Category.Mall,
        ),
        /* THISO MALL */
        Places(
            imageRes = R.drawable.thisomall,
            nameRes = R.string.mall_4_name,
            addressRes = R.string.mall_4_address,
            informationRes = R.string.mall_4_information,
            category = Category.Mall,
        ),
    )
}