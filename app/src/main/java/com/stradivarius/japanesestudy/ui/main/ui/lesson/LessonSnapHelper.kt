package com.stradivarius.japanesestudy.ui.main.ui.lesson

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.absoluteValue
import kotlin.math.sign

internal class LessonSnapHelper(
    private val viewmodel: LessonViewModel
) : LinearSnapHelper() {

    var startView: View? = null

    override fun findTargetSnapPosition(
        layoutManager: RecyclerView.LayoutManager?,
        velocityX: Int,
        velocityY: Int
    ): Int {
        if ((layoutManager !is RecyclerView.SmoothScroller.ScrollVectorProvider)
            || startView == null) {
            return RecyclerView.NO_POSITION
        }
        val nextPosition = if (velocityX.absoluteValue > 3000) {
            layoutManager.getPosition(startView!!) + velocityX.sign
        }
        else {
            layoutManager.getPosition(startView!!)
        }
        if (nextPosition < 0 || nextPosition >= viewmodel.getSymbolList().size) {
            return RecyclerView.NO_POSITION
        }
        viewmodel.setNextPosition(nextPosition)
        return nextPosition

    }
}