package com.wcc.whatdoilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wcc.whatdoilearn.data.LearnedItemDao
import com.wcc.whatdoilearn.entities.LearnedItem
import kotlinx.coroutines.launch

class LearnedItemViewModel(private var dao: LearnedItemDao) : ViewModel() {
    val learnedItems: LiveData<List<LearnedItem>>

    init {
        learnedItems = dao.getAll()
    }

    fun insertNewLearnedItem(item: LearnedItem) {
        viewModelScope.launch {
            dao.insert(item)
        }
    }

}