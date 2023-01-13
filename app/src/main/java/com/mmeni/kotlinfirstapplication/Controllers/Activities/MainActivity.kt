package com.mmeni.kotlinfirstapplication.Controllers.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.mmeni.kotlinfirstapplication.R

class MainActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var toolbar: Toolbar = findViewById(R.id.activity_main_toolbar)
    private var drawnerLayout: DrawerLayout = findViewById(R.id.activity_main_drawer_layout)
    private var navigationView: NavigationView = findViewById(R.id.activity_main_nav_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.configureToolBar()
        this.configureDrawerLayout()
        this.configureNavigationView()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (this.drawnerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawnerLayout.closeDrawer(GravityCompat.START)
        }
//        else {
//            super.onBackPressed()
//        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.activity_main_drawer_news -> print("fragment news")
            R.id.activity_main_drawer_profile -> print("profile")
            R.id.activity_main_drawer_settings -> print("params")
        }

        this.drawnerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    // ---------------------
    // CONFIGURATION
    // ---------------------

    private fun configureToolBar() {
//        this.toolbar = findViewById(R.id.activity_main_toolbar)
        setSupportActionBar(toolbar)
    }

    private fun configureDrawerLayout() {
//        this.drawnerLayout = findViewById(R.id.activity_main_drawer_layout)
        val toogle = ActionBarDrawerToggle(this, drawnerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawnerLayout.addDrawerListener(toogle)
        toogle.syncState()
    }

    private fun configureNavigationView() {
//        this.navigationView = findViewById(R.id.activity_main_nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

}