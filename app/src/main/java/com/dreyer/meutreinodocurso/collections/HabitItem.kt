package com.dreyer.meutreinodocurso.collections

/**
 * Habit Model representing an Item in a ListView
 *
 * @param title is the title of the habit
 * @param isCompleted wether the habit is checked or noy
 */

data class HabitItem(
    val id: String,
    val title:String,
    val subtitle: String,
    val isCompleted: Boolean
)
