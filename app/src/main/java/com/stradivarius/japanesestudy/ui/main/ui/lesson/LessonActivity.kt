package com.stradivarius.japanesestudy.ui.main.ui.lesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.stradivarius.japanesestudy.R
import kotlinx.android.synthetic.main.lesson_activity.*

internal class LessonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lesson_activity)
        setupToolbar(lesson_toolbar)
        supportFragmentManager.beginTransaction()
            .add(
                R.id.lesson_container,
                LessonFragment.newInstance(
                    applicationContext
                )
            )
            .commitNow()
    }

    private fun setupToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        setTitle(R.string.lesson_toolbar_title)
        toolbar.setTitleTextColor(resources.getColor(R.color.cardview_light_background))
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}