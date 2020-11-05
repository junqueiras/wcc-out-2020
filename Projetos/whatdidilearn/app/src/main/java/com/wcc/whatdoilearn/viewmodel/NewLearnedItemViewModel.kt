package com.wcc.whatdoilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wcc.whatdoilearn.data.LearnedItemDao
import com.wcc.whatdoilearn.entities.LearnedItem
import com.wcc.whatdoilearn.entities.UnderstandingLevel
import kotlinx.coroutines.launch

class NewLearnedItemViewModel(private var dao: LearnedItemDao): ViewModel() {

    fun insertNewLearnedItem(itemTitle: String, itemDescription: String) {
        viewModelScope.launch {
            val item = LearnedItem(itemTitle, itemDescription, UnderstandingLevel.HIGH)
            dao.insert(item)
        }
    }
}