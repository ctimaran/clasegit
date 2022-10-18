package com.stasoft.clasegit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.stasoft.clasegit.databinding.ActivityMainBinding
import com.stasoft.clasegit.fragments.DatosFragment
import com.stasoft.clasegit.fragments.MainFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding:ActivityMainBinding
    private lateinit var actionBarDrawerToggle:ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Habilitar el Menu lateral
        actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerLayout,
        R.string.nav_open,R.string.nav_close)
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_logout->{
                finishAffinity()
            }
            R.id.nav_settings->{
                val transaccion = supportFragmentManager.beginTransaction()
                val fragmento = DatosFragment()
                transaccion.replace(R.id.fragmentContainerView,fragmento)
                transaccion.addToBackStack(null)
                transaccion.commit()

            }
            R.id.nav_home->{
                val transaccion = supportFragmentManager.beginTransaction()
                val fragmento = MainFragment()
                transaccion.replace(R.id.fragmentContainerView,fragmento)
                transaccion.addToBackStack(null)
                transaccion.commit()
            }

            else ->{
                Toast.makeText(this,item.title,Toast.LENGTH_SHORT).show()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}