package com.example.pizzaapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaapp.databinding.FragmentMenuBinding
import com.example.pizzaapp.presentation.adapter.ProductAdapter
import com.example.pizzaapp.presentation.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogFragment : BaseFragment() {

    private var _menuUI: FragmentMenuBinding? = null
    private val menuUI: FragmentMenuBinding
        get() = _menuUI!!

    private val productViewModel: ProductViewModel by viewModels()

    private val productAdapter = ProductAdapter()

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

        productViewModel.fetchPizzas()
    }

    override fun onDestroy() {
        super.onDestroy()
        _menuUI = null
    }

    private fun initViews() {

        with(menuUI) {
            menuRecyclerView.layoutManager = LinearLayoutManager(context)
            menuRecyclerView.adapter = productAdapter
        }
    }

    private fun observe() {
        productViewModel.observablePizzas.observe(viewLifecycleOwner) { pizzaList ->
            productAdapter.submitList(pizzaList)
        }
    }
}