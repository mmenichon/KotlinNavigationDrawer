package com.mmeni.kotlinfirstapplication.Controllers.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.mmeni.kotlinfirstapplication.R

class MainActivity(var toolbar: Toolbar, var drawnerLayout: DrawerLayout, var navigationView: NavigationView) : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }

    // ---------------------
    // CONFIGURATION
    // ---------------------

    fun configureToolBar() {
        this.toolbar = findViewById(R.id.activity_main_toolbar)
        setSupportActionBar(toolbar)
    }

    fun configureDrawerLayout() {
        this.drawnerLayout = findViewById(R.id.activity_main_drawer_layout)
        val toogle = ActionBarDrawerToggle(this, drawnerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawnerLayout.addDrawerListener(toogle)
        toogle.syncState()
    }

    fun configureNavigationView() {
        this.navigationView = findViewById(R.id.activity_main_nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

}