package com.stradivarius.japanesestudy.ui.main.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.stradivarius.japanesestudy.ui.main.data.AppDataBase

internal interface LocalSessionWrapper {

    fun init(context: Context?)

}