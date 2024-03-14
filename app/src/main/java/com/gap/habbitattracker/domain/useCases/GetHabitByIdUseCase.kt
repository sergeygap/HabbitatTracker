package com.gap.habbitattracker.domain.useCases

import com.gap.habbitattracker.domain.HabitRepository
import com.gap.habbitattracker.domain.entities.Habit

class GetHabitByIdUseCase(
    private val repository: HabitRepository
) {
     operator fun invoke(id: Int): Habit {
        return repository.getHabitById(id)
    }
}