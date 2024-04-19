package com.example.retrofitwithkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.example.Results

class RecyclerViewAdapter(private val context: Context, private val dataList: ArrayList<Results>): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item.author.toString())

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val textView : TextView = itemView.findViewById<TextView>(R.id.textView2);

        fun bind(item: String){
            textView.text = item
        }
    }


}