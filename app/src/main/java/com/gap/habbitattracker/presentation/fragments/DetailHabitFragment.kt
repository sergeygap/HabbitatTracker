package com.gap.habbitattracker.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gap.habbitattracker.databinding.FragmentDetailHabitBinding
import com.gap.habbitattracker.domain.entities.Habit
import com.gap.habbitattracker.presentation.fragments.viewModels.DetailsHabitViewModel


class DetailHabitFragment : Fragment() {
    private lateinit var viewModel: DetailsHabitViewModel
    private val binding: FragmentDetailHabitBinding
        get() = _binding ?: throw RuntimeException("DetailHabitFragment == null")
    private var _binding: FragmentDetailHabitBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailHabitBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[DetailsHabitViewModel::class.java]
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments
        if (args == null) {
            addNewHabit()
        }
    }

    private fun addNewHabit() {
        binding.btnSave.setOnClickListener {
            viewModel.addNewHabit(
                Habit(
                    name = binding.etName.text.trim().toString(),
                    description = binding.etDescription.text.trim().toString(),
                    countReady = binding.etCountReady.text.toString().toInt(),
                    period = binding.etCountPeriod.text.toString().toInt(),
                    type = binding.rgType.findViewById<RadioButton>(binding.rgType.checkedRadioButtonId)
                        .text.toString(),
                    priority = binding.spinnerPriority.selectedItem.toString()
                )
            )
            requireActivity().onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}