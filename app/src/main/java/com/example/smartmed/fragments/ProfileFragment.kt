package com.example.smartmed.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.smartmed.R
import com.example.smartmed.databinding.FragmentThirdBinding

class ProfileFragment : Fragment(R.layout.fragment_third) {
    private lateinit var binding: FragmentThirdBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentThirdBinding.bind(view)
    }
}