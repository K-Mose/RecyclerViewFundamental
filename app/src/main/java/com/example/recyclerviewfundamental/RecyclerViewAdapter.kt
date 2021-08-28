package com.example.recyclerviewfundamental

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewfundamental.databinding.ListItemBinding

class RecyclerViewAdapter(private val list: Array<Fruit>, private val clickListener: (Fruit, TextView) -> Unit): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    private lateinit var binding: ListItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),
        parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position], clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(fruit: Fruit, clickListener: (Fruit, TextView) -> Unit) {
            binding.apply{
                tvName.setOnClickListener{
                    clickListener(fruit, tvName)
                }
            }
        }
    }
}