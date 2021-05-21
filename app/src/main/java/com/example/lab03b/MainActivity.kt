package com.example.lab03b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toogle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        toogle.isDrawerIndicatorEnabled=true
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        //Funcion del nav menu

        nav_menu.setNavigationItemSelectedListener(this)

        //Abrir fragments
        setToolbartitle("Home")
        changeFragment(Home())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)

        when(item.itemId){
            R.id.home->{
                setToolbartitle("Home")
                changeFragment(Home())

            }
            R.id.job->{
                setToolbartitle("Job Application")
                changeFragment(FragmentJobApplication())
            }
            R.id.list->{
                setToolbartitle("List Job Application")
                changeFragment(FragmentList())
            }
        }
        return true
    }

    //Cambiar nombre del toolbar
    fun setToolbartitle(title:String){

        supportActionBar?.title=title
    }
    
    fun changeFragment(frag:Fragment){
        val fragment=supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container,frag).commit()
    }




}