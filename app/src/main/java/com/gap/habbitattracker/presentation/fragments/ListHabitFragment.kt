package com.gap.habbitattracker.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gap.habbitattracker.R
import com.gap.habbitattracker.data.HabitRepositoryImpl.listHabit
import com.gap.habbitattracker.databinding.FragmentListHabitBinding
import com.gap.habbitattracker.presentation.fragments.adapters.HabitAdapter


class ListHabitFragment : Fragment() {

    private val binding: FragmentListHabitBinding
        get() = _binding ?: throw RuntimeException("ListHabitFragment == null")
    private var _binding: FragmentListHabitBinding? = null
    private lateinit var adapter: HabitAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListHabitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        workWithUi()
    }

    private fun workWithUi() {
        addNewHabit()
        workWithRecyclerView()
    }



    private fun addNewHabit() {
        binding.addFab.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(
                    R.id.main_fragment_container,
                    DetailHabitFragment()
                )
                .commit()
        }
    }

    private fun workWithRecyclerView() {
        adapter = HabitAdapter()
        binding.mainRv.adapter = adapter

        if (listHabit.isEmpty()) {
            binding.mainRv.visibility = View.GONE
            binding.tvListEmpty.visibility = View.VISIBLE
        } else {
            binding.mainRv.visibility = View.VISIBLE
            binding.tvListEmpty.visibility = View.GONE
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}