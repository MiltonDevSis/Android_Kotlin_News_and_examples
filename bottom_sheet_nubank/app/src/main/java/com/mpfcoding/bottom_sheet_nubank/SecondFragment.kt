package com.mpfcoding.bottom_sheet_nubank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mpfcoding.bottom_sheet_nubank.databinding.FragmentFirstBinding
import com.mpfcoding.bottom_sheet_nubank.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSecondBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root
}