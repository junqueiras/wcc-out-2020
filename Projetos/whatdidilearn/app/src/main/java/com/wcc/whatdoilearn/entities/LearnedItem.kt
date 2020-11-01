package com.wcc.whatdoilearn.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "learned_item")
data class LearnedItem(
        @ColumnInfo(name = "item_title")
        val tittle: String,
        @ColumnInfo(name = "item_description")
        val description: String,
        @Ignore
        val understandingLevel: UnderstandingLevel,
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "item_id")
        val id: Int = 0
)