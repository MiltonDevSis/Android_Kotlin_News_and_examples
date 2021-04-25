package com.example.kotlin_coroutines.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.kotlin_coroutines.R
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.delay

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            MainViewModel.MainViewModelFactory(MainRepository())
        ).get(MainViewModel::class.java)

        viewModel.filmesLiveData.observe(viewLifecycleOwner, Observer { filmes ->
            textViewFilmes.text = filmes[0].titulo
        })

        viewModel.getFilmesCoroutines()
    }

}