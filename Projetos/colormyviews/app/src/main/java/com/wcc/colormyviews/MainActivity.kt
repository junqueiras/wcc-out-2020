package com.wcc.colormyviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var currentColor = R.color.grey

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setColorButtonsAction()
        setBoxesAction()

    }

    private fun setColorButtonsAction() {
        redButton.setOnClickListener {
            currentColor = R.color.red
        }

        yellowButton.setOnClickListener {
            currentColor = R.color.yellow
        }

        greenButton.setOnClickListener {
            currentColor = R.color.green
        }
    }

    private fun setBoxesAction() {
        box_one_text.setOnClickListener {
            colorBoxWithCurrentColor(it)
        }
        box_two_text.setOnClickListener {
            colorBoxWithCurrentColor(it)
        }
        box_three_text.setOnClickListener {
            colorBoxWithCurrentColor(it)
        }
        box_four_text.setOnClickListener {
            colorBoxWithCurrentColor(it)
        }
        box_five_text.setOnClickListener {
            colorBoxWithCurrentColor(it)
        }
    }

    private fun colorBoxWithCurrentColor(box: View) {
            box.setBackgroundResource(currentColor)
    }



}