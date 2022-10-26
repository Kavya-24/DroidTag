package com.example.droidtaglibrary


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class DroidTagAdapter :
    RecyclerView.Adapter<DroidTagAdapter.MyViewHolder>() {

    var tagAdded: MutableList<String> = mutableListOf()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val TAG = itemView.findViewById<TextView>(R.id.item_tag_name)
        val cross = itemView.findViewById<ImageView>(R.id.item_tag_cross)
        val card = itemView.findViewById<CardView>(R.id.item_card)

        fun bindPost(_tag: String) {

            with(_tag) {
                TAG.text = _tag

            }
        }


    }

    fun updateList(_tag: String, position: Int) {
        tagAdded.add(_tag)
        notifyItemInserted(position)        //Not needed
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        tagAdded.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, tagAdded.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_tag, parent, false)
        return DroidTagAdapter.MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return tagAdded.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.cross.setOnClickListener {
            removeAt(position)
        }

        holder.bindPost(tagAdded[position])

    }

}
