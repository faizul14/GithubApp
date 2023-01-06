package com.example.githubapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapp.core.ui.MainActivityAdapter
import com.example.githubapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterList: MainActivityAdapter
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterList = MainActivityAdapter()
        binding.rvDataUser.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = adapterList
        }
        viewModel.getData().observe(this) { data ->
            if (data.isNotEmpty()) {
                adapterList.setData(data)
                binding.rvDataUser.adapter = adapterList
            }
        }
    }
}