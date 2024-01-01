package com.example.imageappwithretrofitgridandlist.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imageappwithretrofitgridandlist.R
import com.example.imageappwithretrofitgridandlist.models.Item
import com.example.imageappwithretrofitgridandlist.utils.Constants.Companion.dateFormat
import kotlinx.android.synthetic.main.data_item.view.*
import java.text.SimpleDateFormat
import java.util.*


class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var imgeList = emptyList<Item>()
    private var isGrid: Boolean = false
    private var context: Context? = null
    private val currentTimestamp = 1704135641507

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context

        if (isGrid) {
            return MyViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.data_item_grid, parent, false)
            )
        } else {

            return MyViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false)
            )
        }
    }

    override fun getItemCount(): Int {
        return imgeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = imgeList.get(position)

        val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.ENGLISH)
        simpleDateFormat.format(currentTimestamp)

        Glide.with(context).load(currentItem.previewURL).into(holder.itemView.item_image);

        holder.itemView.item_tag.text = currentItem.tags.toString()
        holder.itemView.item_type.text = currentItem.type.toString()
        holder.itemView.item_date.text = simpleDateFormat.format(currentTimestamp)
    }

    fun setData(image: List<Item>, isGrid: Boolean) {
        this.imgeList = image
        this.isGrid = isGrid

        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
