package com.example.applemarket

import android.content.ClipData.Item
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemRecyclerviewBinding
import java.text.DecimalFormat

class MarketAdapter(val mItems: MutableList<MyItem>) :
    RecyclerView.Adapter<MarketAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketAdapter.Holder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }
    //상품 가격은 1000단위로 콤마(,) 처리
    fun replaseDecimalFormat(num: Int): String {
        return DecimalFormat("#,###").format(num).toString()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        // 클릭 이벤트를 처리
        holder.itemView.setOnClickListener { itemClick?.onClick(it, position) }
        // 롱 클릭 이벤트를 처리
        holder.itemView.setOnLongClickListener { itemClick?.onPressed(it, position); true }
        holder.productImageView.clipToOutline = true
        holder.productImageView.setImageResource(mItems[position].aIcon)

        holder.name.text = mItems[position].aName
        holder.address.text = mItems[position].aAddress
        //상품 가격은 1000단위로 콤마(,) 처리 + 원
        holder.price.text = replaseDecimalFormat(mItems[position].aPrice) + "원"
        holder.likeCount.text = mItems[position].heartCount.toString()
        holder.chatCount.text = mItems[position].chatCount.toString()


        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
    }

    interface ItemClick {
        // 클릭 이벤트를 처리
        fun onClick(view: View, position: Int)
        // 롱 클릭 이벤트를 처리
        fun onPressed(view: View, postion: Int)
    }

    val itemClick: ItemClick? = null

    override fun getItemCount(): Int = mItems.size

    override fun getItemId(position: Int): Long = position.toLong()

    class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val root = binding.root
        val productImageView = binding.ivProfile
        val name = binding.tvTitle
        val address = binding.tvAddress
        val price = binding.tvPrice
        val likeCount = binding.tvLike
        val chatCount = binding.tvChat
    }


}


