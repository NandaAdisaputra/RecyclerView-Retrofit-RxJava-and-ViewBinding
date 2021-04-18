package com.nandaadisaputra.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nandaadisaputra.recyclerview.adapter.PostItemAdapter
import com.nandaadisaputra.recyclerview.databinding.ActivityMainBinding
import com.nandaadisaputra.recyclerview.network.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.rvListPost.layoutManager = LinearLayoutManager(this)
        ApiClient.client().getAllPosts().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                binding.rvListPost.adapter = PostItemAdapter(it)
            },{


            })

    }
}
