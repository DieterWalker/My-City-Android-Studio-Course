package com.example.mycityandroidstudiocourses.printer

import android.content.Context
import android.graphics.Bitmap
import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.mycityandroidstudiocourses.data.Places
import com.sunmi.printerx.PrinterSdk
import com.sunmi.printerx.SdkException
import com.sunmi.printerx.api.LineApi
import com.sunmi.printerx.enums.Align
import com.sunmi.printerx.enums.DividingLine
import com.sunmi.printerx.enums.ErrorLevel
import com.sunmi.printerx.style.BaseStyle
import com.sunmi.printerx.style.BitmapStyle
import com.sunmi.printerx.style.QrStyle
import com.sunmi.printerx.style.TextStyle
import kotlin.math.log

/*
    Class Quản lý máy in PrinterX SDK
    - Khởi tạo SDK
    - Kiểm tra máy POS có tích hợp máy in không
*/
class SunmiPrinterManager(private val context: Context) {
    // Khai báo máy in mặt định
    private var printer: PrinterSdk.Printer? = null

    // Khởi tạo máy in
    fun init(onResult: (Boolean) -> Unit){
        try{
            PrinterSdk.getInstance().getPrinter(context, object : PrinterSdk.PrinterListen {
                /* Gọi hàm khi tìm thấy máy in*/
                override fun onDefPrinter(printerSdk: PrinterSdk.Printer?) {
                    printer = printerSdk
                    onResult(true)
                }

                // Hiện danh sách các máy in khác
                override fun onPrinters(printers: MutableList<PrinterSdk.Printer>?) {
                    /* TO DO */
                }
            })
        } catch (e: SdkException) {
            e.printStackTrace()
            onResult(false)
        }
    }

    /* Hàm kiểm tra nhanh */
    fun isPrinterAvailable(): Boolean{
        return printer != null
    }

    /* Hàm để lấy instance để gọi in */
    fun getPrinter(): PrinterSdk.Printer? {
        return printer
    }

    /* Giải phóng SDK */
    fun destroy(){
        PrinterSdk.getInstance().destroy()
    }

    fun printTest(
        name: String,
        address: String,
        information: String,
        link: String,
        image: Bitmap
    ) {
        printer?.let { p ->
            val lineApi = p.lineApi()

            BillFormatter.printPlaceInformation(
                lineApi = lineApi,
                name = name,
                address = address,
                information = information,
                link = link,
                image = image
            )
        }
    }

}