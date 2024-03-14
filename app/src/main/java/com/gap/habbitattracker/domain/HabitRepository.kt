package com.gap.habbitattracker.domain

import com.gap.habbitattracker.domain.entities.Habit

interface HabitRepository {

    fun getListHabits(): List<Habit>
    fun getHabitById(id: Int): Habit
    suspend fun addHabit(habit: Habit)
    suspend fun editHabit(id: Int)
    suspend fun deleteHabit(habit: Habit)

}