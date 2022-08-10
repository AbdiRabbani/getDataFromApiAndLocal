package com.example.pahlawannasional.api.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pahlawannasional.api.data.UsersResponse
import com.example.pahlawannasional.api.data.UsersResponseItem
import com.example.pahlawannasional.databinding.ActivitySearchUserBinding
import com.example.pahlawannasional.databinding.GridItemBinding
import com.squareup.picasso.Picasso

class SearchAdapter(private val listSearch: List<UsersResponseItem>) : RecyclerView.Adapter<SearchAdapter.MyViewModel>() {
    class MyViewModel(val binding: GridItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewModel(
        GridItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        holder.binding.apply {
            tvName.text = listSearch[position].login
            tvFrom.text = listSearch[position].nodeId
            tvCategory.text = listSearch[position].type

            Picasso.get().load(listSearch[position].avatarUrl).into(profile)
        }
    }

    override fun getItemCount() = listSearch.size

}