package com.demo.timecraft.ui.authentication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatTextView
import com.demo.timecraft.R

class SpinnerAdapter(
    context: Context,
    resorce: Int,
    private val list: ArrayList<String>
) :
    ArrayAdapter<String>(context, resorce, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.raw_spinner_item, parent, false)
        val textView = view.findViewById<AppCompatTextView>(R.id.spinnerItemText)
        textView.text = list[position]
        return view
    }
}