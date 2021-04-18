package com.nandaadisaputra.recyclerview.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nandaadisaputra.recyclerview.databinding.PostItemLayoutBinding
import com.nandaadisaputra.recyclerview.model.PostModel
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class PostItemAdapter(
    var list: List<PostModel>
) : RecyclerView.Adapter<PostItemAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: PostItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(postResponse: Int) {
            binding.tvTitle.text = list[postResponse].title
            binding.tvBody.text = list[postResponse].body
            itemView.onClick {
                itemView.context.toast("Ini "+ list[postResponse].title)
            }
            Log.d("Test2", postResponse.toString())
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            PostItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }
}