package com.wcc.whatdoilearn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wcc.whatdoilearn.data.LearnedItemsDatabase
import com.wcc.whatdoilearn.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.itemsLearnedRecyclerView
        val scope = CoroutineScope(Dispatchers.IO)
        val database = LearnedItemsDatabase.getDatabase(this, scope)
        val learnedItemDao = database.learnedItemDao()

        val adapter = LearnedItemsAdapter()
        recyclerView.adapter = adapter

        scope.launch {
            val learnedItems = learnedItemDao.getAll()
            adapter.data = learnedItems
        }


    }
}