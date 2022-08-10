package com.example.pahlawannasional.api.ui.listusers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pahlawannasional.api.data.UsersResponse
import com.example.pahlawannasional.api.data.UsersResponseItem
import com.example.pahlawannasional.databinding.ActivityListUserBinding
import com.example.pahlawannasional.databinding.GridItemBinding
import com.squareup.picasso.Picasso

class ListUserAdapter(private val listUser : ArrayList<UsersResponseItem>) : RecyclerView.Adapter<ListUserAdapter.MyViewModel>() {

    class MyViewModel(val binding: GridItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewModel(
        GridItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        holder.binding.apply {
            tvName.text = listUser[position].login
            tvCategory.text = listUser[position].type
            tvFrom.text = listUser[position].nodeId

            Picasso.get().load(listUser[position].avatarUrl).into(profile)
        }
    }

    override fun getItemCount() = listUser.size


}