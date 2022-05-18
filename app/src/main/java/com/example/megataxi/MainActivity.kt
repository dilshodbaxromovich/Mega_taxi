package com.example.megataxi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.megataxi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null

    private var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        layoutManager = LinearLayoutManager(this)

        binding.recycleView.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        binding.recycleView.adapter = adapter


    }
}