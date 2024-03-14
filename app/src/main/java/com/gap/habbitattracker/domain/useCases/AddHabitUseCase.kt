package com.gap.habbitattracker.domain.useCases

import com.gap.habbitattracker.domain.HabitRepository
import com.gap.habbitattracker.domain.entities.Habit

class AddHabitUseCase(
    private val repository: HabitRepository
) {
    suspend operator fun invoke(habit: Habit) {
        repository.addHabit(habit)
    }
}