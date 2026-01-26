package com.example.myCity

import com.example.mycityandroidstudiocourses.R
import com.example.mycityandroidstudiocourses.data.Category
import com.example.mycityandroidstudiocourses.data.Places
import com.example.mycityandroidstudiocourses.ui.MyCityViewModel

object MyCityTestData {
    lateinit var viewModel : MyCityViewModel
    val testCategory = Category.Mall
    val testPlace = Places(
        imageRes = R.drawable.gigamall,
        nameRes = R.string.mall_3_name,
        addressRes = R.string.mall_3_address,
        informationRes = R.string.mall_3_information,
        linkRes = R.string.mall_3_link,
        category = Category.Mall
    )
}