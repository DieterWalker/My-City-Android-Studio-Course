package com.example.mycityandroidstudiocourses.printer

import com.sunmi.printerx.enums.Align
import com.sunmi.printerx.enums.ErrorLevel
import com.sunmi.printerx.style.BaseStyle
import com.sunmi.printerx.style.BitmapStyle
import com.sunmi.printerx.style.QrStyle
import com.sunmi.printerx.style.TextStyle

object PrintStyle {
    val baseStyle = BaseStyle().apply{
        setAlign(Align.CENTER)
    }

    val qrStyle = QrStyle.getStyle().apply {
        setDot(8)
        setErrorLevel(ErrorLevel.L)
        setAlign(Align.CENTER)
        setWidth(500)
        setHeight(500)
    }

    val placeNameStyle = TextStyle().apply {
        setTextSize(32)
        enableBold(true)
        enableItalics(false)
    }

    val placeAddressStyle = TextStyle().apply {
        setTextSize(18)
        enableBold(false)
        enableItalics(true)
    }

    val placeInformationStyle = TextStyle().apply {
        setTextSize(24)
        enableBold(false)
        enableItalics(false)
    }

    val bitmapStyle = BitmapStyle.getStyle().apply {
        setWidth(300)
        setHeight(225)
    }
}