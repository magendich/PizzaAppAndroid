package com.example.pizzaapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pizzaapp.R
import com.example.pizzaapp.databinding.ActivityMainBinding
import com.example.pizzaapp.presentation.fragment.CartFragment
import com.example.pizzaapp.presentation.fragment.ContactsFragment
import com.example.pizzaapp.presentation.fragment.CatalogFragment
import com.example.pizzaapp.presentation.fragment.ProfileFragment
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

        replaceFragment(CatalogFragment())
        fragmentNavigation()
    }

    private fun fragmentNavigation() {

        mainActivityUI.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.catalogBN -> replaceFragment(CatalogFragment.newInstance())
                R.id.profileBN -> replaceFragment(ProfileFragment.newInstance())
                R.id.contactsBN -> replaceFragment(ContactsFragment.newInstance())
                R.id.cartBN -> replaceFragment(CartFragment.newInstance())
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