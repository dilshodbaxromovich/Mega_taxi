package com.example.loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Order_Page_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_page)
        supportActionBar?.hide()

        val name = intent.getStringExtra("name")
        val txt = findViewById<TextView>(R.id.txt_driver)

        txt.text = name
    }
}