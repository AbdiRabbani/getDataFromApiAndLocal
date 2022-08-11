package com.example.pahlawannasional.api.ui.searchrepo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pahlawannasional.api.data.RepoResponseItem
import com.example.pahlawannasional.api.ui.searchUser.SearchAdapter
import com.example.pahlawannasional.databinding.GridItemBinding
import com.squareup.picasso.Picasso

class SearchRepoAdapter(private val listRepo : List<RepoResponseItem>) : RecyclerView.Adapter<SearchRepoAdapter.MyViewModel>() {
    class MyViewModel(val binding: GridItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchRepoAdapter.MyViewModel(
        GridItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        holder.binding.apply {
            Picasso.get().load(listRepo[position].owner?.avatarUrl).into(profile)

            tvName.text = listRepo[position].name
            tvFrom.text = "owner : ${listRepo[position].owner?.login}"
            tvCategory.text = "visibility : ${listRepo[position].visibility}"
        }
    }

    override fun getItemCount() = listRepo.size
}