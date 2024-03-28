package com.gap.habbitattracker.domain.entities

data class Habit(
    val id: Int = 0,
    val name: String,
    val description: String,
    val priority: String,
    val type: String,
    val countReady: Int,
    val period: Int
)

