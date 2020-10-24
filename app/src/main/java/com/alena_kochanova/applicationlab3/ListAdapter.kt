package com.alena_kochanova.applicationlab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListAdapter : RecyclerView.Adapter<ListAdapter.CarViewHolder>() {

    var dataF = listOf<MainActivity.CarCategory>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = dataF.size

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val item : MainActivity.CarCategory = dataF[position]
        holder.setData(item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder.from(parent)
    }


    class CarViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.name)

        fun setData(item: MainActivity.CarCategory) {
            textView.text = item.actor

        }

        companion object {
            fun from(parent: ViewGroup): CarViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.list_item, parent, false)

                return CarViewHolder(view)
            }
        }
    }

}



class ListAdapter2 : RecyclerView.Adapter<ListAdapter2.ElemViewHolder>() {
    var data = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ElemViewHolder, position: Int) {
        val item = data[position]
        holder.setData(item)
        fun onClick(v: View) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElemViewHolder {
        return ElemViewHolder.from(parent)
    }


    class ElemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewRow: TextView = itemView.findViewById(R.id.view_cars)


        fun setData(item: String) {
            textViewRow.text = item
        }

        companion object {
            fun from(parent: ViewGroup): ElemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.list_items, parent, false)

                return ElemViewHolder(view)
            }
        }
    }

}