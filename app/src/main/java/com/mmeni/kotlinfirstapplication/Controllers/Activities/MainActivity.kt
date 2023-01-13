package com.mmeni.kotlinfirstapplication.Controllers.Activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.mmeni.kotlinfirstapplication.Controllers.Fragments.NewsFragment
import com.mmeni.kotlinfirstapplication.Controllers.Fragments.ParamsFragment
import com.mmeni.kotlinfirstapplication.Controllers.Fragments.ProfileFragment
import com.mmeni.kotlinfirstapplication.R

class MainActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var toolbar: Toolbar
    private lateinit var drawnerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    private lateinit var fragmentNews: Fragment
    private lateinit var fragmentProfile: Fragment
    private lateinit var fragmentParams: Fragment

    private val FRAGMENT_NEWS = 0
    private val FRAGMENT_PROFILE = 1
    private val FRAGMENT_PARAMS = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.configureToolBar()
        this.configureDrawerLayout()
        this.configureNavigationView()
        this.showFirstFragment()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (this.drawnerLayout.isDrawerOpen(GravityCompat.START))
            this.drawnerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.activity_main_drawer_news -> this.showFragment(FRAGMENT_NEWS)
            R.id.activity_main_drawer_profile -> this.showFragment(FRAGMENT_PROFILE)
            R.id.activity_main_drawer_settings -> this.showFragment(FRAGMENT_PARAMS)
        }

        this.drawnerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    // ---------------------
    // CONFIGURATION
    // ---------------------

    private fun configureToolBar() {
        this.toolbar = findViewById(R.id.activity_main_toolbar)
        setSupportActionBar(toolbar)
    }

    private fun configureDrawerLayout() {
        this.drawnerLayout = findViewById(R.id.activity_main_drawer_layout)
        val toogle = ActionBarDrawerToggle(this, drawnerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawnerLayout.addDrawerListener(toogle)
        toogle.syncState()
    }

    private fun configureNavigationView() {
        this.navigationView = findViewById(R.id.activity_main_nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    // ---------------------
    // FRAGMENTS
    // ---------------------

    private fun showFirstFragment() {
        val visibleFragment = supportFragmentManager.findFragmentById(R.id.activity_main_frame_layout)
        if (visibleFragment == null) {
            this.showFragment(FRAGMENT_NEWS)
            this.navigationView.menu.getItem(0).isChecked = true
        }
    }

    private fun showFragment(fragmentId: Int) {
        when (fragmentId) {
            FRAGMENT_NEWS -> this.showNewsFragment()
            FRAGMENT_PROFILE -> this.showProfileFragment()
            FRAGMENT_PARAMS -> this.showParamsFragment()
        }
    }

    private fun showNewsFragment() {
        this.fragmentNews = NewsFragment.newInstance()
        this.startTransactionFragment(this.fragmentNews)
    }

    private fun showProfileFragment() {
        this.fragmentProfile = ProfileFragment.newInstance()
        this.startTransactionFragment(this.fragmentProfile)
    }

    private fun showParamsFragment() {
        this.fragmentParams = ParamsFragment.newInstance()
        this.startTransactionFragment(this.fragmentParams)
    }

    // FragmentManager affiche un de nos trois fragments dans le FrameLayout
    private fun startTransactionFragment(fragment: Fragment) {
        if (!fragment.isVisible)
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_main_frame_layout, fragment).commit()
    }

}