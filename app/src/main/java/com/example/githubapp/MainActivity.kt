package com.example.githubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapp.core.ui.MainActivityAdapter
import com.example.githubapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : MainActivityAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter =  MainActivityAdapter()
        binding.rvDataUser.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = adapter
        }
        viewModel.getData().observe(this){data->
            if (data.isNotEmpty()){
                adapter.setData(data)
                binding.rvDataUser.adapter = adapter
            }
        }

    }
}