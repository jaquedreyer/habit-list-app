package com.dreyer.meutreinodocurso.dummy

import com.dreyer.meutreinodocurso.collections.HabitItem
import java.util.UUID

/**
 * Mock data with [HabitItem] for the collection.
 */

object MockHabits {

    val habitItemList:MutableList<HabitItem> = mutableListOf(
        HabitItem(
            id =UUID.randomUUID().toString(),
            title = "Read the book",
            subtitle = "15 minutes every day",
            isCompleted = false
        ),
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
}