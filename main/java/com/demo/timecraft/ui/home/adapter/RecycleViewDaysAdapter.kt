package com.demo.timecraft.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.demo.timecraft.R
import com.demo.timecraft.model.Days

class RecycleViewDaysAdapter(
    val list: ArrayList<Days>
) : RecyclerView.Adapter<RecycleViewDaysAdapter.ViewHolder>() {

    lateinit var context: Context

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textViewDayName = v.findViewById<AppCompatTextView>(R.id.textViewDayName)
        val textViewDayNumber = v.findViewById<AppCompatTextView>(R.id.textViewDayNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.raw_recycle_view_days,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (list[position].dayName.equals("Today")) {
            holder.textViewDayName.setTextColor(ContextCompat.getColor(context, R.color.colorRed))
            holder.textViewDayNumber.setTextColor(ContextCompat.getColor(context, R.color.colorRed))
        }
        holder.textViewDayName.text = list[position].dayName
        holder.textViewDayNumber.text = list[position].dayNumber
    }
}