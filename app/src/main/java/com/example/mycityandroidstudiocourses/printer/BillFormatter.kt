package com.example.mycityandroidstudiocourses.printer

import android.graphics.Bitmap
import com.sunmi.printerx.api.LineApi
import java.time.format.TextStyle

/* Cấu hình file in */
object BillFormatter {
    fun printPlaceInformation(
        lineApi: LineApi,
        name: String,
        address: String,
        information: String,
        link: String,
        image: Bitmap
    ){
        printSpace(lineApi)
        printImage(lineApi, image)
        printSpace(lineApi)
        printName(lineApi, name)
        printSpace(lineApi)
        printAddress(lineApi, address)
        printSpace(lineApi)
        printInformation(lineApi, information)
        printSpace(lineApi)
        printDivider(lineApi)
        printSpace(lineApi)
        printQR(lineApi, link)
        printSpace(lineApi)
        printSpace(lineApi)

        cutPaper(lineApi)
    }

    /* Cắt giấy */
    private fun cutPaper(lineApi: LineApi){
        lineApi.autoOut()
    }

    /* Hàm in tên địa danh */
    private fun printName(
        lineApi: LineApi,
        name: String
    ){
        lineApi.printText(name, PrintStyle.placeNameStyle)
    }

    /* Hàm in địa chỉ địa danh */
    private fun printAddress(
        lineApi: LineApi,
        address: String
    ){
        lineApi.printText(address, PrintStyle.placeAddressStyle)
    }

    /* Hàm in thông tin địa danh */
    private fun printInformation(
        lineApi: LineApi,
        information: String
    ){
        lineApi.printText(information, PrintStyle.placeInformationStyle)
    }

    /* Hàm in khoảng trắng */
    private fun printSpace(lineApi: LineApi){
        lineApi.printText("  ", PrintStyle.placeInformationStyle)
    }

    /* Hàm in gạch ngang */
    private fun printDivider(lineApi: LineApi){
        lineApi.printText("--------------", PrintStyle.placeInformationStyle)
    }

    /* In hinh ảnh*/
    private fun printImage(
        lineApi: LineApi,
        bitmap: Bitmap
    ){
        lineApi.printBitmap( bitmap , PrintStyle.bitmapStyle)
    }

    /* In QR */
    private fun printQR(
        lineApi: LineApi,
        content: String
    ){
        lineApi.printQrCode( content , PrintStyle.qrStyle)
    }
}