package com.example.mvvmjun9.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmjun9.databinding.ActivityMainBinding
import com.example.mvvmjun9.viewmodel.PostViewModel
import com.example.mvvmjun9.viewmodel.PostsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding
        lateinit var viewModel: PostViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            viewModel = ViewModelProvider(this)[PostViewModel::class]

            viewModel.fetchPosts()
            init()
        }

        fun init() {
            viewModel.posts.observe(this, Observer { posts ->
                binding.recyclerView.adapter = PostsAdapter(posts)
            })
        }
    }
}