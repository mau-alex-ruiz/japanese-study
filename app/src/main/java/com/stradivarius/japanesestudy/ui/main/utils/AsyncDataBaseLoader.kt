package com.stradivarius.japanesestudy.ui.main.utils

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl

internal class AsyncDataBaseLoader : AsyncTask<Context, Void, String>() {

    override fun doInBackground(vararg params: Context?): String {
        LocalSessionWrapperImpl.init(params[0])
        return "Database Loaded Successfully"
    }

}