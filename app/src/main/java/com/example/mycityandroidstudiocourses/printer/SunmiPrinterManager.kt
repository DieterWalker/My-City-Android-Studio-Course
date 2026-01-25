package com.example.mycityandroidstudiocourses.printer

import android.content.Context
import com.sunmi.printerx.PrinterSdk
import com.sunmi.printerx.SdkException

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
}