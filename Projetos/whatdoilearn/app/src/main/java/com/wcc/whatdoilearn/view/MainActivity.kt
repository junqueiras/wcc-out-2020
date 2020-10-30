package com.wcc.whatdoilearn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.wcc.whatdoilearn.R
import com.wcc.whatdoilearn.data.LearnedItemsDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.itemsLearnedRecyclerView)
        val learnedItems = LearnedItemsDatabase().getAll()
        val adapter = LearnedItemsAdapter()

        recyclerView.adapter = adapter
        adapter.data = learnedItems
    }
}