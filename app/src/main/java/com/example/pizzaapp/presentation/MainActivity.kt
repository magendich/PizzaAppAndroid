package com.example.pizzaapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.pizzaapp.R
import com.example.pizzaapp.databinding.ActivityMainBinding
import com.example.pizzaapp.presentation.fragment.Cart
import com.example.pizzaapp.presentation.fragment.Contacts
import com.example.pizzaapp.presentation.fragment.Menu
import com.example.pizzaapp.presentation.fragment.Profile
import com.example.pizzaapp.presentation.viewmodel.PizzaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _mainActivityUI: ActivityMainBinding? = null
    private val mainActivityUI: ActivityMainBinding
        get() = _mainActivityUI!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mainActivityUI = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityUI.root)

        replaceFragment(Menu())
        fragmentNavigation()
    }

    private fun fragmentNavigation() {

        mainActivityUI.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menuBN -> replaceFragment(Menu())
                R.id.profileBN -> replaceFragment(Profile())
                R.id.contactsBN -> replaceFragment(Contacts())
                R.id.cartBN -> replaceFragment(Cart())
            }
            true
        }
    }


    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}