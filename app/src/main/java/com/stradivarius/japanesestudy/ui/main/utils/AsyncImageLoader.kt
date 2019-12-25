package com.stradivarius.japanesestudy.ui.main.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import com.stradivarius.japanesestudy.ui.main.ui.lesson.LessonAdapter
import java.lang.Exception

internal class AsyncImageLoader(private val holder: LessonAdapter.ImageViewHolder) : AsyncTask<String, Void, Bitmap?>() {

    override fun doInBackground(vararg urls: String?): Bitmap? {
        val url = urls[0]
        var bmp: Bitmap? = null

        try {
            val inputStream = java.net.URL(url).openStream()
            bmp = BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            Log.e("Image Load Error", e.message ?: "Failed to load bitmap.")
            e.printStackTrace()
        }
        return bmp
    }

    override fun onPostExecute(result: Bitmap?) {
        holder.setImage(result)
    }

}