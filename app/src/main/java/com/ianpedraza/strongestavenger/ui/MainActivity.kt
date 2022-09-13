package com.ianpedraza.strongestavenger.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ianpedraza.strongestavenger.R
import com.ianpedraza.strongestavenger.databinding.ActivityMainBinding
import com.ianpedraza.strongestavenger.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivWanda.setOnClickListener { viewModel.onImagePressed(MainViewModel.WANDA) }
        binding.ivStrange.setOnClickListener { viewModel.onImagePressed(MainViewModel.STRANGE) }
        binding.ivCarol.setOnClickListener { viewModel.onImagePressed(MainViewModel.CAROL) }

        viewModel.text.observe(this) { name ->
            name?.let {
                binding.tvSelected.text = name
            }
        }

        viewModel.image.observe(this) { image ->
            image?.let {
                binding.ivSelected.setImageResource(image)
            }
        }
    }
}