package com.example.githubapp.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubapp.core.domain.model.ModelDataUser
import com.example.githubapp.databinding.ItemUserBinding

class MainActivityAdapter : RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {
    private val listData = ArrayList<ModelDataUser>()

    fun setData(newData: List<ModelDataUser>) {
        listData.clear()
        listData.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataUser: ModelDataUser) {
            Glide.with(itemView.context)
                .load(dataUser.avatarUrl)
                .into(binding.imgUser)
            binding.nameUser.text = dataUser.login
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}