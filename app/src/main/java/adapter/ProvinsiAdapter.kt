package com.example.infocovid_19

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infocovid_19.model.ProvinsiResponse

class ProvinceAdapter (private var list: ArrayList<ProvinsiResponse>): RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>(){
    inner class ProvinceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(province: ProvinsiResponse){
            with(itemView){
                val tvName = findViewById<TextView>(R.id.tvName)
                val tvPositive = findViewById<TextView>(R.id.tvPositive)
                val tvRecover = findViewById<TextView>(R.id.tvRecover)
                val tvDeath = findViewById<TextView>(R.id.tvDeath)

                tvName.text = province.attributes.province
                tvPositive.text = province.attributes.positive.toString()
                tvRecover.text = province.attributes.recover.toString()
                tvDeath.text = province.attributes.death.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_province, parent, false)
        return ProvinceViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.bind(list[position])
    }
}