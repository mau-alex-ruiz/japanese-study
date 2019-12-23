package com.stradivarius.japanesestudy.ui.main.ui.lesson

import android.view.View
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.absoluteValue
import kotlin.math.sign

internal class LessonSnapHelper : LinearSnapHelper() {

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
        return if (velocityX.absoluteValue > 3000) {
            layoutManager.getPosition(startView!!) + velocityX.sign
        }
        else {
            layoutManager.getPosition(startView!!)
        }
    }

}