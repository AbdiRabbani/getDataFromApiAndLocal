package com.example.pahlawannasional.api.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pahlawannasional.api.data.UsersResponse
import com.example.pahlawannasional.api.data.UsersResponseItem
import com.example.pahlawannasional.api.ui.listusers.ListUserAdapter
import com.example.pahlawannasional.databinding.ActivitySearchUserBinding

class SearchUserActivity : AppCompatActivity() {

    private var _binding : ActivitySearchUserBinding? = null
    private val binding get() = _binding as ActivitySearchUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivitySearchUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(SearchUserViewModel::class.java)

        binding.btnSearch.setOnClickListener {
            viewModel.searchUser(binding.textInputSearch.text.toString())
            viewModel.apply {
                getSearchUser()
                listUser.observe(this@SearchUserActivity) {
                    showData(it)
                }
            }
        }

        viewModel.getSearchUser().observe(this){
            Log.i("DATA", "onCreate: $it \n \n \n Nama Usernya -----> ${it.item?.get(0)?.login}")
            println(it.item?.get(0)?.login)
        }
    }


    private fun showData(data: UsersResponse){
        val dataResult = data.item
        binding.rvSearch.apply {
            layoutManager = LinearLayoutManager(this@SearchUserActivity)
            adapter = dataResult?.let { SearchAdapter(it) }
        }
    }
}