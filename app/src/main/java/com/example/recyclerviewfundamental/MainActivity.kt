package com.example.recyclerviewfundamental

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewfundamental.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fruitsList = arrayOf(
        Fruit("Apple","Tom"),
        Fruit("Banana","Joe"),
        Fruit("WaterMelon","Martine"),
        Fruit("Grape","Bart"),
        Fruit("Guava","Ned"),
        Fruit("Orange","Ralph"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            myRV.also{ rv ->
                rv.setBackgroundColor(Color.BLACK)
                rv.layoutManager = LinearLayoutManager(this@MainActivity)
                rv.adapter = RecyclerViewAdapter(fruitsList) { selectedFruitItem: Fruit, tv: TextView ->
                    listItemClicked(selectedFruitItem, tv)
                }
            }
        }
    }

    private fun listItemClicked(fruit: Fruit, view: TextView) {
        view.text = fruit.name
    }
}