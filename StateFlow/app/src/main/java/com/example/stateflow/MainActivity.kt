package com.example.stateflow

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.stateflow.databinding.ActivityMainBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    private var uiStateJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGetSomething.setOnClickListener {
            viewModel.getSomething()
        }
    }

    override fun onStart() {
        super.onStart()
        uiStateJob = lifecycleScope.launchWhenStarted {
            viewModel.uiStateFlow.collect { uiState ->
                when (uiState) {
                    MainViewModel.UiState.Sucess -> {
                        binding.run {
                            flipperFlow.displayedChild = 1
                            progressFlow.isVisible = false
                            binding.textHelloFlow.text = getString(R.string.hello_flow)
                        }
                    }
                    MainViewModel.UiState.Error -> {
                        binding.run {
                            flipperFlow.displayedChild = 1
                            progressFlow.isVisible = false
                            binding.textHelloFlow.text = getString(R.string.error)
                        }
                    }
                    MainViewModel.UiState.Loading -> {
                        binding.run {
                            flipperFlow.displayedChild = 1
                            progressFlow.isVisible = true
                        }
                    }
                    MainViewModel.UiState.Initial -> binding.progressFlow.isVisible = false
                }
            }
        }
    }

    override fun onStop() {
        uiStateJob?.cancel()
        super.onStop()
    }
}