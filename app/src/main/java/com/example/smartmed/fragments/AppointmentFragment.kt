package com.example.smartmed.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartmed.R
import com.example.smartmed.adapter.AppointmentAdapter
import com.example.smartmed.databinding.FragmentAppointmentBinding
import com.example.smartmed.model.AppointmentModel
import com.example.smartmed.repository.AppointmentRepository

class AppointmentFragment : Fragment(R.layout.fragment_appointment) {
    private lateinit var binding: FragmentAppointmentBinding
    private val appointmentAdapter = AppointmentAdapter { appointment ->
        // Обработка клика по записи
        handleAppointmentClick(appointment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAppointmentBinding.bind(view)

        setupRecyclerView()
        loadAppointments()
    }

    private fun setupRecyclerView() {
        binding.doctorsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = appointmentAdapter
        }
    }

    private fun loadAppointments() {
        // Здесь будет загрузка данных с сервера
        // Пока используем тестовые данные
        val testData = AppointmentRepository.generateSampleAppointments()
            // Добавьте больше тестовых данных при необходимости


        appointmentAdapter.submitList(testData)
    }

    private fun handleAppointmentClick(appointment: AppointmentModel) {
        // Обработка записи к врачу
        Toast.makeText(
            requireContext(),
            "Запись к ${appointment.fio} на ${appointment.startTime}",
            Toast.LENGTH_SHORT
        ).show()
    }
}