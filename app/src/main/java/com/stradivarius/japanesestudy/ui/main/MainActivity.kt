package com.stradivarius.japanesestudy.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.ui.main.data.AppDataBase
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl
import com.stradivarius.japanesestudy.ui.main.utils.AsyncDataBaseLoader
import java.util.*

class MainActivity : AppCompatActivity() {

    private val databaseLoadObserver: Observer<AppDataBase> = Observer {
        it.also {
            showMainFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
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
            .replace(
                R.id.container,
                LoadingFragment.newInstance()
            )
            .commitNow()
    }

}
