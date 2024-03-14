package com.gap.habbitattracker.domain.useCases

import com.gap.habbitattracker.domain.HabitRepository
import com.gap.habbitattracker.domain.entities.Habit

class GetListHabitsUseCase(
    private val repository: HabitRepository
) {
    operator fun invoke(): List<Habit> {
        return repository.getListHabits()
    }
}