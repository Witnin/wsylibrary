package com.wsy.hi.library.app.demo.log

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wsy.hi.library.app.R
import com.wsy.wsy.library.log.*

class HiLogDemoActivity : AppCompatActivity() {
    var viewPrinter: HiViewPrinter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_log_demo)
        viewPrinter = HiViewPrinter(this)
        findViewById<View>(R.id.btn_log).setOnClickListener {
            printLog()
        }
        viewPrinter!!.viewProvider.showFloatingView()
    }

    private fun printLog() {
        HiLogManager.getInstance().addPrinter(viewPrinter)
        HiLog.log(object : HiLogConfig() {
            override fun includeThread(): Boolean {
                return false
            }
        }, HiLogType.E, "---", "5566")
        HiLog.a("9900")
    }
}