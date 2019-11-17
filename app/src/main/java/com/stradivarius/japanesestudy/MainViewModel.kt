package com.stradivarius.japanesestudy

import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.lifecycle.ViewModel
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.stradivarius.japanesestudy.ui.main.common.BaseViewModel
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.net.URL

internal class MainViewModel : BaseViewModel() {

    val str: String = "If this appears, databinding worked."

    fun provideStr(): String = str
    override fun init() {

    }

}
