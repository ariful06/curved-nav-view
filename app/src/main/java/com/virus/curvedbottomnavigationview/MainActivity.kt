package com.virus.curvedbottomnavigationview

import android.provider.Settings
import com.virus.curvedbottomnavigationview.drawer.HomeFragment
import com.virus.curvedbottomnavigationview.drawer.ProfileFragment
import com.virus.curvedbottomnavigationview.drawer.SettingsFragment
import com.virus.curvedbottomnavigationview.drawer.ShareFragment
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener
{

    private var bottomNavigationView : BottomNavigationView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView  = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView?.background = null
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener {
            val intent = Intent(this, DrawerActivity::class.java)
            startActivity(intent)
        }
        bottomNavigationView?.setOnNavigationItemSelectedListener(this)
        replace(HomeFragment())
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_home ->replace(HomeFragment())
            R.id.action_profile ->replace(ProfileFragment())
            R.id.action_settings ->replace(SettingsFragment())
            R.id.action_share ->replace(ShareFragment())
        }
        return true // not false!
    }
    private fun replace(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}