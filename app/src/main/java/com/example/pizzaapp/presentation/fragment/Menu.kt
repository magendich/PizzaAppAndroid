package com.example.pizzaapp.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaapp.databinding.FragmentMenuBinding
import com.example.pizzaapp.presentation.PizzaAdapter
import com.example.pizzaapp.presentation.viewmodel.PizzaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Menu : Fragment() {

    private var _menuUI: FragmentMenuBinding? = null
    private val menuUI: FragmentMenuBinding
        get() = _menuUI!!

    private val pizzaViewModel: PizzaViewModel by viewModels()

    private val pizzaAdapter = PizzaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _menuUI = FragmentMenuBinding.inflate(inflater, container, false)
        return menuUI.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observe()

        pizzaViewModel.fetchPizzas()
    }

    override fun onDestroy() {
        super.onDestroy()
        _menuUI = null
    }

    private fun initViews() {

        with(menuUI) {
            menuRecyclerView.layoutManager = LinearLayoutManager(context)
            menuRecyclerView.adapter = pizzaAdapter
        }
    }

    private fun observe() {
        pizzaViewModel.observablePizzas.observe(viewLifecycleOwner) { pizzaList ->
            pizzaAdapter.submitList(pizzaList)
        }
    }
}