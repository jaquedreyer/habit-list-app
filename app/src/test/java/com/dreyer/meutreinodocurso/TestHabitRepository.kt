package com.dreyer.meutreinodocurso

import com.dreyer.meutreinodocurso.collections.HabitItem
import com.dreyer.meutreinodocurso.core.HabitsRepository
import java.util.UUID

/**
 * Simple Repository to be used for test purpose.
 */
class TestHabitRepository : HabitsRepository {

    private val habitList = mutableListOf<HabitItem>()

    override fun fetchHabits() = habitList  //retornar a lista de habitos

    override fun addRandomNewHabit() {   //para fins de teste pode add sempre o mesmo item
        habitList.add(
            HabitItem(
                id = UUID.randomUUID().toString(),
                title = "Read the book",
                subtitle = "15 minutes every day",
                isCompleted = false
            )
        )
    }

    override fun toggleHabitCompleted(id: String) {
        val index = habitList.indexOfFirst { it.id == id } //primeiro buscar o index do habit que tem aquele id que informei acima
        habitList[index] = habitList[index].copy(isCompleted = !habitList[index].isCompleted) //acessar esse index/posicao fazendo uma copia do valor atual mas sendo invertido para marcar
    }
}