package com.mpfcoding.bottom_sheet_nubank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mpfcoding.bottom_sheet_nubank.databinding.ActivityMainBinding.inflate
import com.mpfcoding.bottom_sheet_nubank.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMainBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        binding.buttonMain.setOnClickListener {
            val directions = MainFragmentDirections.actionMainFragmentToFirstFragment2()
            findNavController().navigate(directions)
        }
    }
}