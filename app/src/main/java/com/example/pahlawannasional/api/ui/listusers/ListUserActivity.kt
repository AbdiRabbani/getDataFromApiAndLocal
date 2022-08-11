package com.example.pahlawannasional.api.ui.listusers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pahlawannasional.api.data.UsersResponseItem
import com.example.pahlawannasional.api.ui.searchrepo.SearchRepoActivity
import com.example.pahlawannasional.api.ui.searchUser.SearchUserActivity
import com.example.pahlawannasional.databinding.ActivityListUserBinding

class ListUserActivity : AppCompatActivity() {

    private var _binding: ActivityListUserBinding? = null
    private val binding get() = _binding as ActivityListUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnRepo.setOnClickListener {
                startActivity(Intent(this@ListUserActivity, SearchRepoActivity::class.java))
            }
            btnSearch.setOnClickListener {
                startActivity(Intent(this@ListUserActivity, SearchUserActivity::class.java))
            }
        }

        val viewModel = ViewModelProvider(this).get(ListUsersViewModel::class.java)
        viewModel.getListUsers()
        viewModel.getResultListUsers().observe(this) {
            Log.i("LISTUSERS", "onCreate: $it")
        }

        viewModel.apply {
            getListUsers()
            listUsers.observe(this@ListUserActivity) {showData(it as ArrayList<UsersResponseItem>)}
        }
    }

    private fun showData(data: ArrayList<UsersResponseItem>) {
        binding.rvListUser.apply {
            layoutManager = LinearLayoutManager(this@ListUserActivity)
            adapter = ListUserAdapter(data)
        }
    }
}