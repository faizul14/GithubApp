package com.example.githubapp.detail

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.core.domain.model.ModelDetailUser
import com.example.core.domain.model.ModelRepoUser
import com.example.core.ui.RepoUserAdapter
import com.example.githubapp.databinding.ActivityDetailUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding
    private lateinit var adapterList: RepoUserAdapter
    private val viewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterList = RepoUserAdapter()
        binding.rvRepoUser.apply {
            layoutManager = LinearLayoutManager(this@DetailUserActivity)
            setHasFixedSize(true)
            adapter = adapterList
        }
        val data = intent.getStringExtra("EXTRA_NAME")
        if (data != null) {
            loadDataDetailUser(data)
        }

    }

    private fun loadDataDetailUser(username: String) {
        viewModel.getDetailUser(username).observe(this) { dataDetail ->
            if (dataDetail != null) {
                viewDisplay(dataDetail)
            }
        }
    }

    private fun viewDisplay(data: ModelDetailUser) {
        Glide.with(this)
            .load(data.avatarUrl)
            .into(binding.itmDetail.imgDetaiUser)
        binding.apply {
            itmDetail.txtNameUser.text = data.name
            itmDetail.txtUsernameUser.text = data.login
            itmDetail.txtBioUser.text = data.bio
        }

        viewModel.getRepoUser(username = data.login.toString()).observe(this) { dataRepo ->
            if (dataRepo.isNotEmpty()) {
                loadDataRepo(dataRepo)
            }
        }
    }

    private fun loadDataRepo(data: List<ModelRepoUser>) {
        adapterList.setData(data)
        binding.rvRepoUser.adapter = adapterList
        binding.apply {
            progresbar.visibility = View.GONE
            itmDetail.root.visibility = View.VISIBLE
            rvRepoUser.visibility = View.VISIBLE
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}