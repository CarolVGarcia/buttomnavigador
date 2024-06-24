package com.example.appmenubuttom92

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.btnNavigator)
        bottomNavigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.btnhome -> {
                    cambiarFrame(HomeFragment())
                    true
                }

                R.id.btnlista -> {
                    cambiarFrame(ListaFragment())
                    true
                }
                R.id.btndata ->{
                    cambiarFrame(DbFragment())
                    true
                }
                R.id.btnacerca ->{
                    cambiarFrame(AcercaFragment())
                    true
                }

                else -> false


            }
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun cambiarFrame(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frmContenedor, fragment).commit()



    }
}