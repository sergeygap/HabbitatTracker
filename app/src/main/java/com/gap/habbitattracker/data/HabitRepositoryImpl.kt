package com.gap.habbitattracker.data

import com.gap.habbitattracker.domain.HabitRepository
import com.gap.habbitattracker.domain.entities.Habit
import com.gap.habbitattracker.domain.entities.Priority
import com.gap.habbitattracker.domain.entities.Type

object HabitRepositoryImpl: HabitRepository {

     val listHabit = mutableListOf<Habit>().apply {
//        repeat(10) {
//            this.add(Habit(
//                id = it,
//                name = "Habit $it",
//                description = "sdfsdfssdfsdfsdfsdfsdfsdfsdfsdfsdfffffFFFFFFFFF",
//                priority = Priority.LOW,
//                type = Type.USEFUL,
//                countReady = it,
//                period = it
//            ))
//        }
    }

    override  fun getListHabits(): List<Habit> {
        return listHabit
    }

    override fun getHabitById(id: Int): Habit {
        return listHabit.find { id == it.id } ?: throw RuntimeException("id (habit) is not found")
    }

    override suspend fun addHabit(habit: Habit) {
        listHabit.add(habit.copy(id = listHabit.size))
    }

    override suspend fun editHabit(id: Int) {

    }

    override suspend fun deleteHabit(habit: Habit) {

    }

}