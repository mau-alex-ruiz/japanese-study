package com.stradivarius.japanesestudy.ui.main.utils

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.ProgressBar
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl

class AsyncDataBaseLoader : AsyncTask<Context, Void, String>() {

    override fun onPreExecute() {
        super.onPreExecute()
        Log.i("PreExecute", "onPreExecute of database loader")
    }

    override fun doInBackground(vararg params: Context?): String {
        LocalSessionWrapperImpl.init(params[0])
        return "Database Loaded Successfully"
    }

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        Log.i("PostExecute", "onPostExecute of database loader")
    }

}