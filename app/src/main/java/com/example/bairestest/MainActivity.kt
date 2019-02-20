package com.example.bairestest

import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.bairestest.fragments.ButtonsFragment
import com.example.bairestest.fragments.GoogleFragment
import com.example.bairestest.fragments.ReposFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val googleFragment by lazy { GoogleFragment.newInstance() }
    private val buttonsFragment by lazy { ButtonsFragment.newInstance() }
    private val reposFragment by lazy { ReposFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onResume() {
        super.onResume()
        supportFragmentManager.replace(R.id.container, reposFragment, "repos")
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.drawer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_google -> supportFragmentManager.replace(R.id.container, googleFragment, "google")
            R.id.nav_buttons-> supportFragmentManager.replace(R.id.container, buttonsFragment, "buttons")
            R.id.nav_repos -> supportFragmentManager.replace(R.id.container, reposFragment, "repos")
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}



fun androidx.fragment.app.FragmentManager.replace(container: Int, fragment: androidx.fragment.app.Fragment, tag: String) { beginTransaction().replace(container, fragment, tag).commitAllowingStateLoss() }
