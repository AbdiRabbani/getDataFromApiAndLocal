package com.example.pahlawannasional.localjson

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pahlawannasional.databinding.GridItemBinding
import com.squareup.picasso.Picasso

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.MyViewHolder>() {

    class MyViewHolder(val binding : GridItemBinding) : RecyclerView.ViewHolder(binding.root)

    private var listHeroes = ArrayList<Hero>()

    fun setData(list: List<Hero>){
        if (list == null) return
        listHeroes.clear()
        listHeroes.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
            GridItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            tvName.text = listHeroes[position].nama
            tvFrom.text = listHeroes[position].asal
            tvCategory.text = listHeroes[position].kategori

            Picasso.get().load(listHeroes[position].image).into(profile)
        }
    }

    override fun getItemCount() = listHeroes.size
}