package com.gap.habbitattracker.presentation.fragments.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gap.habbitattracker.data.HabitRepositoryImpl
import com.gap.habbitattracker.domain.entities.Habit
import com.gap.habbitattracker.domain.useCases.AddHabitUseCase
import kotlinx.coroutines.launch

class DetailsHabitViewModel : ViewModel() {
    private val habitRepositoryImpl = HabitRepositoryImpl
    private val addHabitUseCase = AddHabitUseCase(habitRepositoryImpl)

    fun addNewHabit(habit: Habit) {
        viewModelScope.launch {
            addHabitUseCase(habit)
        }
    }
}