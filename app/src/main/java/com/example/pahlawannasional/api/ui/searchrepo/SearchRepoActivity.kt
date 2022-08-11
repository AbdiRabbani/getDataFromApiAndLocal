package com.example.pahlawannasional.api.ui.searchrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pahlawannasional.R
import com.example.pahlawannasional.api.data.RepoResponse
import com.example.pahlawannasional.api.data.UsersResponse
import com.example.pahlawannasional.api.ui.searchUser.SearchAdapter
import com.example.pahlawannasional.api.ui.searchUser.SearchUserViewModel
import com.example.pahlawannasional.databinding.ActivitySearchRepoBinding

class SearchRepoActivity : AppCompatActivity() {

    private var _binding : ActivitySearchRepoBinding?= null
    private val binding get() = _binding as ActivitySearchRepoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivitySearchRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(SearchRepoViewModel::class.java)

        binding.btnSearch.setOnClickListener {
            viewModel.searchRepo(binding.textInputSearch.text.toString())
            viewModel.apply {
                getSerchRepo()
                listRepo.observe(this@SearchRepoActivity) {
                    showData(it)
                }
            }
        }

//        viewModel.getSerchRepo().observe(this){
//            Log.i("DATA", "onCreate: $it \n \n \n Nama Usernya -----> ${it.item?.get(0)?.login}")
//            println(it.item?.get(0)?.login)
//        }
    }


    private fun showData(data: RepoResponse){
        val dataResult = data.item
        binding.rvSearch.apply {
            layoutManager = LinearLayoutManager(this@SearchRepoActivity)
            adapter = dataResult?.let { SearchRepoAdapter(it) }
        }
    }
}