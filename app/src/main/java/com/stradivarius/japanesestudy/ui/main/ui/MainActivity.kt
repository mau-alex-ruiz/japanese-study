package com.stradivarius.japanesestudy.ui.main.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.ui.main.data.AppDataBase
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl
import com.stradivarius.japanesestudy.ui.main.ui.lesson.LessonActivity
import com.stradivarius.japanesestudy.ui.main.ui.loading.LoadingFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private lateinit var optionsMenu: Menu

    private val databaseLoadObserver: Observer<AppDataBase> = Observer {
        it.also {
            showMainFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupToolbar(main_toolbar)
        if (savedInstanceState == null || LocalSessionWrapperImpl.database.value == null) {
            LocalSessionWrapperImpl.database.observeForever(databaseLoadObserver)
            showLoadingFragment()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.level_selector, menu)
        optionsMenu = menu!!
        return true
    }

    private fun showMainFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_container,
                MainFragment.newInstance(
                    applicationContext
                )
            )
            .commitNow()
    }

    private fun showLoadingFragment() {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.main_container,
                LoadingFragment.newInstance()
            )
            .commitNow()
    }

    private fun setupToolbar(toolbar: Toolbar) {
        setTitle(R.string.app_name)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.cardview_light_background))
        toolbar.setNavigationOnClickListener {
            with(supportFragmentManager) {
                if (this.fragments[this.backStackEntryCount - 1].tag == "FromMainFragment") {
                    setTitle(R.string.app_name)
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    supportActionBar?.setDisplayShowHomeEnabled(false)
                    setStartActionVisibility(false)
                }
                this.popBackStack()
            }
        }
    }

    fun setStartActionVisibility(shouldShow: Boolean) {
        optionsMenu.findItem(R.id.action_start).isVisible = shouldShow
    }


    fun startLessonActivity(menuItem : MenuItem) {
        if (LocalSessionWrapperImpl.getCheckBoxMap().isEmpty()) {
            Snackbar.make(findViewById(R.id.main_container), R.string.need_level_selection, Snackbar.LENGTH_SHORT)
                .show()
        }
        else {
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
        }
    }

}
