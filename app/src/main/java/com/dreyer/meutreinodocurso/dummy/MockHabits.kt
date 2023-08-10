package com.dreyer.meutreinodocurso.dummy

import com.dreyer.meutreinodocurso.collections.HabitItem
import com.dreyer.meutreinodocurso.core.HabitsRepository
import java.util.UUID

/**
 * Mock data with [HabitItem] for the collection.
 */

object MockHabits : HabitsRepository {

    private val randomHabitList = listOf(
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Walk the dog",
            subtitle = "At 8 am",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Do the dishes",
            subtitle = "After meals",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Go to the gym",
            subtitle = "Every day at 6 am",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Code every day",
            subtitle = "At least 4 hours per day",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Make a cup of tea",
            subtitle = "Before going to sleep",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Make a cup of coffee",
            subtitle = "At any time",
            isCompleted = false
        )
    )

    private val habitItemList:MutableList<HabitItem> = mutableListOf(
        HabitItem(
            id =UUID.randomUUID().toString(),
            title = "Read the book",
            subtitle = "15 minutes every day",
            isCompleted = false
        )
    )
    override fun fetchHabits() = habitItemList.map {it.copy()}
    override fun addRandomNewHabit() {
       habitItemList.add(randomHabit())
    }
    override fun toggleHabitCompleted(id: String) {
        val habitIndex = findHabitIndexById(id)
        val habit = habitItemList[habitIndex]
        habitItemList[habitIndex] = habit.copy(isCompleted = !habit.isCompleted)
    }
    private fun randomHabit() = randomHabitList.random().copy(
        id = UUID.randomUUID().toString()
    )

    private fun findHabitIndexById(id: String) = habitItemList.indexOfFirst { habitItem ->
        habitItem.id == id
    }
}