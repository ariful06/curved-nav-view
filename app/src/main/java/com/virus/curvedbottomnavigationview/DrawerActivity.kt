package com.virus.curvedbottomnavigationview

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.virus.curvedbottomnavigationview.drawer.HomeFragment
import com.virus.curvedbottomnavigationview.drawer.ProfileFragment
import com.virus.curvedbottomnavigationview.drawer.SettingsFragment
import com.virus.curvedbottomnavigationview.drawer.ShareFragment
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle


class DrawerActivity : AppCompatActivity() {

    private var drawerLayout: DuoDrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        init()

    }

    private fun init() {

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById<View>(R.id.drawer) as DuoDrawerLayout
        val drawerToggle = DuoDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawerLayout?.setDrawerListener(drawerToggle)
        drawerToggle.syncState()


        val contentView = drawerLayout?.contentView
        val menuView = drawerLayout?.menuView

        val ll_Home = menuView?.findViewById<LinearLayout>(R.id.ll_Home)
        val ll_Profile = menuView?.findViewById<LinearLayout>(R.id.ll_Profile)
        val ll_Setting = menuView?.findViewById<LinearLayout>(R.id.ll_Setting)
        val ll_Share = menuView?.findViewById<LinearLayout>(R.id.ll_Share)
        val ll_Logout = menuView?.findViewById<LinearLayout>(R.id.ll_Logout)


        ll_Home?.setOnClickListener {
            closeDrawer()
            replace(HomeFragment())
        }
        ll_Profile?.setOnClickListener {
            closeDrawer()
            replace(ProfileFragment())

        }
        ll_Setting?.setOnClickListener {
            closeDrawer()
            replace(SettingsFragment())

        }
        ll_Share?.setOnClickListener {
            closeDrawer()
            replace(ShareFragment())

        }
        ll_Logout?.setOnClickListener { Toast.makeText(this, "Logout", Toast.LENGTH_LONG).show() }

        replace(HomeFragment())

    }

    fun closeDrawer() {
        if (drawerLayout?.isDrawerOpen != null && drawerLayout?.isDrawerOpen!!) {
            drawerLayout?.closeDrawer(Gravity.START);
        }
    }

    private fun replace(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
    }
}