package com.dreyer.meutreinodocurso

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dreyer.meutreinodocurso.collections.HabitListViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HabitListViewModelTest {

    /**
     * InstantTaskExecutorRule swaps the background executor used by the Architecture Components
     * with a different one which executes each task synchronously.
     */
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testHabitRepository = TestHabitRepository()
    private val viewModel = HabitListViewModel(testHabitRepository)

    @Before
    fun setup(){
        testHabitRepository.habitList.clear()
    }

    @Test
    fun `Verify if uiState is init with data`() {
        //Prepare
        testHabitRepository.addRandomNewHabit()

        //Execute
        val uiState = viewModel.stateOnceAndStream().getOrAwaitValue()

        //Verify
        assert(uiState.habitItemList.isNotEmpty())
    }

    @Test
    fun `Verify if uiState is updated when a habit is toggled`(){
        //Observar uiState
        //Marcar um habito como concluido
        //Pegar o uiState atualizado
        //Verificar se agora ele esta concluido

        //Prepare

        //Execute

        //Verify
    }
}