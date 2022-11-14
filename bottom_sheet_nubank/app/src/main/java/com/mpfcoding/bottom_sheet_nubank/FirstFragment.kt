package com.mpfcoding.bottom_sheet_nubank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mpfcoding.bottom_sheet_nubank.databinding.FragmentFirstBinding

class FirstFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentFirstBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()
    }

    private fun listeners(){
        binding.buttonFirst.setOnClickListener {
            val directions = FirstFragmentDirections.actionFirstFragment2ToSecondFragment()
            findNavController().navigate(directions)
        }
    }
}