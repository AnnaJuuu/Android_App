package com.example.applemarket

import android.content.ClipData.Item
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemRecyclerviewBinding

class MarketAdapter(val mItems: MutableList<MyItem>) :
    RecyclerView.Adapter<MarketAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketAdapter.Holder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.productImageView.setImageResource(mItems[position].aIcon)
        holder.name.text = mItems[position].aName
        holder.address.text = mItems[position].aAddress
        holder.price.text = mItems[position].aPrice.toString()
        holder.likeCount.text = mItems[position].heartCount.toString()
        holder.likeIcon.setImageResource(mItems[position].aIconHeart)
        holder.chatCount.text = mItems[position].chatCount.toString()
        holder.chatIcon.setImageResource(mItems[position].aIconChat)


        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    val itemClick: ItemClick? = null

    override fun getItemCount(): Int = mItems.size

    override fun getItemId(position: Int): Long = position.toLong()

    class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val root = binding.root
        val productImageView = binding.ivProfile
        val name = binding.tvName
        val address = binding.tvAddress
        val price = binding.tvPrice
        val likeCount = binding.tvLike
        val likeIcon = binding.ivLike
        val chatCount = binding.tvChat
        val chatIcon = binding.ivChat
    }


}


