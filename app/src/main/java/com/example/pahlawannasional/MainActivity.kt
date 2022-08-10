package com.example.pahlawannasional

import android.content.Intent
import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pahlawannasional.api.ui.listusers.ListUserActivity
import com.example.pahlawannasional.databinding.ActivityMainBinding
import com.example.pahlawannasional.localjson.Hero
import com.example.pahlawannasional.localjson.HeroAdapter
import com.example.pahlawannasional.localjson.JsonActivity
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPahlawan.setOnClickListener {
                startActivity(Intent(this@MainActivity, JsonActivity::class.java))
            }
            btnGithub.setOnClickListener {
                startActivity(Intent(this@MainActivity, ListUserActivity::class.java))
            }
        }
    }
}