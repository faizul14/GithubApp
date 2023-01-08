package com.example.githubapp.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapp.R
import com.example.githubapp.core.domain.model.ModelRepoUser
import com.example.githubapp.core.utils.DateUtils
import com.example.githubapp.databinding.ItemRepoUserBinding

class RepoUserAdapter : RecyclerView.Adapter<RepoUserAdapter.ViewHolder>() {
    private val listData = ArrayList<ModelRepoUser>()

    fun setData(newData: List<ModelRepoUser>) {
        listData.clear()
        listData.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemRepoUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ModelRepoUser) {
            binding.apply {
                nameRepo.setText(data.name)
                descriptionRepo.setText(data.description)
                starsCountRepo.setText(data.stargazersCount.toString())
                val update = itemView.context.getString(R.string.update, DateUtils.getDateUpdate(data.updatedAt!!))
                updateRepoStatus.setText(update)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemRepoUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}