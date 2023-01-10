package com.example.core.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.databinding.ItemUserBinding
import com.example.core.domain.model.ModelDataUser

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
            itemView.setOnClickListener{
                val move = Intent(itemView.context, Class.forName("com.example.githubapp.detail.DetailUserActivity"))
                move.putExtra("EXTRA_NAME", dataUser.login)
                itemView.context.startActivity(move)
            }
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