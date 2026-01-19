package com.example.mycityandroidstudiocourses.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Places(
    /** Places Image **/
    @DrawableRes val imageRes: Int,
    /** Places Name **/
    @StringRes val nameRes: Int,
    /** Places Address **/
    @StringRes val addressRes: Int,
    /** Places Information **/
    @StringRes val informationRes: Int,
    /** Places Category **/
    var category: Category
)
