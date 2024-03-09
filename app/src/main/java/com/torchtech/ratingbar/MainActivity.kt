package com.torchtech.ratingbar

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val display = findViewById<TextView>(R.id.display)
        val rateButton = findViewById<Button>(R.id.rateButton)

        display.text= getString(R.string.good)

        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            when (rating.toInt()){
                1 -> display.text = getString(R.string.very_bad)
                2 -> display.text = getString(R.string.bad)
                3 -> display.text = getString(R.string.good)
                4 -> display.text = getString(R.string.very_good)
                5 -> display.text = getString(R.string.excellent)
                else -> display.text = getString(R.string.no_rating)
            }
            rateButton.setOnClickListener {
                Toast.makeText(this,"Your rating is $rating",Toast.LENGTH_SHORT).show()
            }
        }
    }
}