package com.example.thx_fridge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thx_fridge.databinding.ItemModelBinding

class ShopViewHolder(val binding: ItemModelBinding) : RecyclerView.ViewHolder(binding.root)

class ShopAdapter(val list: ArrayList<String>):
        RecyclerView.Adapter<ShopViewHolder>() {

            override fun getItemCount():Int = list.size

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
                val binding = ItemModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ShopViewHolder(binding)
            }

            override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
                holder.binding.shopText.text = list[position]

                holder.binding.btnDelete.setOnClickListener{
                    list.removeAt(position)
                    notifyDataSetChanged()
                }
            }

}