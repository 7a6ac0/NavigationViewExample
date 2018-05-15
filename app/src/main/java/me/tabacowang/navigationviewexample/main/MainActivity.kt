package me.tabacowang.navigationviewexample.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.tabacowang.navigationviewexample.R
import me.tabacowang.navigationviewexample.util.replaceFragmentInActivity
import me.tabacowang.navigationviewexample.util.setupActionBar

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var bottomNavigationView: BottomNavigationView

    enum class FragmentType {
        home, dashboard, notification
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        setupActionBar(R.id.toolbar) {
            setDisplayShowHomeEnabled(true)
        }

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout).apply {
            setStatusBarBackground(R.color.colorPrimaryDark)
        }

        // set navigation Listener
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation).apply {
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        }

        // start from Home
        changeFragmentTo(FragmentType.home)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.navigation_home -> {
                changeFragmentTo(FragmentType.home)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_dashboard -> {
                changeFragmentTo(FragmentType.dashboard)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_notifications -> {
                changeFragmentTo(FragmentType.notification)
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }

    private fun changeFragmentTo(type: FragmentType) {
        lateinit var selectedFragment: MainContract.View
        when(type) {
            FragmentType.home -> {
                selectedFragment = HomeFragment.newInstance().also {
                    replaceFragmentInActivity(it, R.id.container)
                }
            }

            FragmentType.dashboard -> {
                selectedFragment = DashboardFragment.newInstance().also {
                    replaceFragmentInActivity(it, R.id.container)
                }
            }

            FragmentType.notification -> {
                selectedFragment = NotificationFragment.newInstance().also {
                    replaceFragmentInActivity(it, R.id.container)
                }
            }
        }
        MainPresenter(selectedFragment)
    }
}
