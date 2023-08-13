package com.afrzxd.wholang

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListLang(private val ListOnLang: ArrayList<Lang>) : RecyclerView.Adapter<ListLang.ListLangViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListLangViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_lang, parent, false)
        return ListLangViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListLangViewHolder, position: Int) {

        val (name , tahun , since ,owner, description, photo, ) = ListOnLang[position]

        holder.tvName.text = name
        holder.tvTahun.text = tahun
        holder.tvSince.text = since
        holder.tvOwner.text = owner
        holder.tvDescription.text = description
        holder.imgPhoto.setImageResource(photo)
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Membuka " + ListOnLang[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("name", ListOnLang[holder.adapterPosition].name)
            intent.putExtra("since", ListOnLang[holder.adapterPosition].since)
            intent.putExtra("owner", ListOnLang[holder.adapterPosition].owner)
            intent.putExtra("desc", ListOnLang[holder.adapterPosition].description)
            intent.putExtra("photo", ListOnLang[holder.adapterPosition].photo)
            holder.itemView.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int = ListOnLang.size

    class ListLangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.txt_name_lang)
        val tvTahun: TextView = itemView.findViewById(R.id.tahun_rilis)
        val tvSince: TextView = itemView.findViewById(R.id.txt_since_lang)
        val tvOwner: TextView = itemView.findViewById(R.id.txt_owner_lang)
        val tvDescription: TextView = itemView.findViewById(R.id.txt_desc_lang)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }
}