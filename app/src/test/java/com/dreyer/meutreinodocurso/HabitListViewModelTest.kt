package com.dreyer.meutreinodocurso

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dreyer.meutreinodocurso.collections.HabitItem
import com.dreyer.meutreinodocurso.collections.HabitListViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Assert
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
        //Prepare
        testHabitRepository.habitList.add(HabitItem("ID", "Title habit test", "Subtitle habit test", false))
        val uiState = viewModel.stateOnceAndStream().getOrAwaitValue()

        //Execute
        viewModel.toggleHabitCompleted(uiState.habitItemList.first().id)

        //Verify
        assert(uiState.habitItemList.first().isCompleted)
    }
}