package com.example.colorguessgame

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class AnswerAdapter(private val ansList: ArrayList<String>):
    RecyclerView.Adapter<colorViewHolder>() {


    private var colorMap1 = mutableMapOf<String, String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): colorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listitems, parent,false)
        return colorViewHolder(view)
    }

    override fun onBindViewHolder(holder: colorViewHolder, position: Int) {
        colorMap1 = mutableMapOf("Red" to "#FFFF0000", "Blue" to "#FF07AEFA",
            "Yellow" to "#FFFFEB3B", "Green" to "#FF08A50F",
            "Orange" to "#FFFF5722", "Purple" to "#FF7736E9", "Pink" to "#FFF333DF")

        val currentColor = ansList[position]
        holder.colorView.setBackgroundColor(Color.parseColor(colorMap1.getValue(currentColor)))

    }

    override fun getItemCount(): Int {
        return ansList.size
    }


}

class colorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val colorView : ImageView = itemView.findViewById(R.id.imageAns)
}