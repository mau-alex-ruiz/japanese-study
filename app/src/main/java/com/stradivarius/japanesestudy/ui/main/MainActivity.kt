package com.stradivarius.japanesestudy.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.ui.main.common.BaseToolbarFragment
import com.stradivarius.japanesestudy.ui.main.data.AppDataBase
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl
import com.stradivarius.japanesestudy.ui.main.ui.LoadingFragment
import com.stradivarius.japanesestudy.ui.main.ui.levelselector.LevelSelectorFragment
import kotlinx.android.synthetic.main.main_activity.*
import java.util.logging.Level

class MainActivity : AppCompatActivity() {

    private val databaseLoadObserver: Observer<AppDataBase> = Observer {
        it.also {
            showMainFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupToolbar(toolbar)
        if (savedInstanceState == null || LocalSessionWrapperImpl.database.value == null) {
            LocalSessionWrapperImpl.database.observeForever(databaseLoadObserver)
            showLoadingFragment()
        }
    }

    private fun showMainFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                MainFragment.newInstance(
                    applicationContext
                )
            )
            .commitNow()
    }

    private fun showLoadingFragment() {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.container,
                LoadingFragment.newInstance()
            )
            .commitNow()
    }

    private fun setupToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.cardview_light_background))
        toolbar.setNavigationOnClickListener {
            with(supportFragmentManager) {
                if (this.fragments[this.backStackEntryCount - 1].tag == "FromMainFragment") {
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    supportActionBar?.setDisplayShowHomeEnabled(false)
                }
                this.popBackStack()
            }
        }
    }

}
