package com.wcc.whatdoilearn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wcc.whatdoilearn.R

class NewItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_item)
        supportActionBar?.title = "New Learned Item"
    }
}