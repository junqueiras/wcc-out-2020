package com.wcc.todayscocktail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.wcc.todayscocktail.R
import com.wcc.todayscocktail.network.Cocktail
import com.wcc.todayscocktail.repository.CocktailsListRepository
import com.wcc.todayscocktail.viewmodel.CocktailsListViewModel
import com.wcc.todayscocktail.viewmodel.CocktailsListViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelFactory = CocktailsListViewModelFactory(CocktailsListRepository())
        val viewModel = ViewModelProvider(this, viewModelFactory).get(CocktailsListViewModel::class.java)
        val list = viewModel.cocktailList

        val recyclerView = findViewById<RecyclerView>(R.id.cocktailsListRecyclerView)
        val adapter = CocktailsListAdapter()
        recyclerView.adapter = adapter

        list.observe(this, Observer {
            adapter.data = it
        })
    }
}