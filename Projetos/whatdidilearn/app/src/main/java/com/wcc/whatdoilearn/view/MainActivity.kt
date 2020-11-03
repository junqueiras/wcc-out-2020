package com.wcc.whatdoilearn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wcc.whatdoilearn.data.LearnedItemDao
import com.wcc.whatdoilearn.data.LearnedItemsDatabase
import com.wcc.whatdoilearn.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var learnedItemsDao: LearnedItemDao
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.itemsLearnedRecyclerView
        val scopeDB = CoroutineScope(Dispatchers.IO)
        val database = LearnedItemsDatabase.getDatabase(this, scopeDB)
        learnedItemsDao = database.learnedItemDao()

        recyclerView.adapter = LearnedItemsAdapter()

    }

    override fun onResume() {
        super.onResume()

        val scopeMain = CoroutineScope(Dispatchers.Main)
        scopeMain.launch {
            val learnedItems = learnedItemsDao.getAll()
            (binding.itemsLearnedRecyclerView.adapter as LearnedItemsAdapter).data = learnedItems
        }
    }
}