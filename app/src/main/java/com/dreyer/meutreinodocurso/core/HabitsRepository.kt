package com.dreyer.meutreinodocurso.core

import com.dreyer.meutreinodocurso.collections.HabitItem

interface HabitsRepository {

    //funcao que vai retornar uma lista de habitItems/buscar um habito
    fun fetchHabits(): List<HabitItem>

    //adicionar novo habito - nova feature/funcionalidade
    fun addRandomNewHabit()

    //onde vamos marcar um habito como concluido e vamos passar o id do habito
    fun toggleHabitCompleted(id:String)
}