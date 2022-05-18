package com.example.megataxi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var distances = arrayOf("0.5", "1.0", "1.6", "2.4")

    private var client_loc = arrayOf("MegaSoft", "Bozor", "Park", "Makdap")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_not, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
      holder.client_distance.text = distances[position]
      holder.client_name.text = client_loc[position]
    }

    override fun getItemCount(): Int {
      return distances.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var client_name: TextView
        var client_distance: TextView

        init {
            client_name = itemView.findViewById(R.id.location_client)
            client_distance = itemView.findViewById(R.id.distance)


            itemView.setOnClickListener{
                val position: Int = adapterPosition

            }
        }

    }

}