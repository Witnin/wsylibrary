package com.wsy.hi.library.app

import android.app.Application
import com.google.gson.Gson
import com.wsy.wsy.library.log.HiConsolePrinter
import com.wsy.wsy.library.log.HiFilePrinter
import com.wsy.wsy.library.log.HiLogConfig
import com.wsy.wsy.library.log.HiLogManager

class MyApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        HiLogManager.init(
            object : HiLogConfig() {
                override fun injectJsonParser(): JsonParser? {
                    return JsonParser { src -> Gson().toJson(src) }
                }

                override fun getGlobalTag(): String {
                    return "MApplication"
                }

                override fun enable(): Boolean {
                    return true
                }

                override fun includeThread(): Boolean {
                    return true
                }

                override fun stackTraceDepth(): Int {
                    return 5
                }
            },
            HiConsolePrinter(),
            HiFilePrinter.getInstance(applicationContext.cacheDir.absolutePath, 0)
        )
    }
}