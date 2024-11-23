package com.example.smartmed.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.smartmed.R
import com.example.smartmed.databinding.FragmentIndicatorBinding
import kotlin.random.Random

class IndicatorFragment : Fragment(R.layout.fragment_indicator) {
    private lateinit var binding: FragmentIndicatorBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentIndicatorBinding.bind(view)

        updateIndicators()

        binding.updateButton.setOnClickListener {
            updateIndicators()
        }

    }

    private fun updateIndicators() {
        val pulse = Random.nextInt(60, 100).toString() // Пульс от 60 до 99
        val pressureSystolic = Random.nextInt(110, 130) // Систолическое давление от 110 до 129
        val pressureDiastolic = Random.nextInt(70, 90) // Диастолическое давление от 70 до 89
        val breathing = Random.nextInt(12, 20).toString() // Частота дыхания от 12 до 19
        val saturation = "${Random.nextInt(95, 100)}%" // Сатурация от 95% до 99%

        with(binding) {
            pulseValue.text = "$pulse уд/мин"
            pressureValue.text = "$pressureSystolic/$pressureDiastolic"
            breathingValue.text = "$breathing/мин"
            saturationValue.text = saturation
        }
    }

}