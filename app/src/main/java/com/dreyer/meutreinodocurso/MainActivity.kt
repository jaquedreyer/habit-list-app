package com.dreyer.meutreinodocurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.dreyer.meutreinodocurso.collections.HabitListViewModel
import com.dreyer.meutreinodocurso.dummy.MockHabits

class MainActivity : AppCompatActivity() {

    //instanciar aqui o viewmodel
    private val viewModel : HabitListViewModel by viewModels {
        HabitListViewModel.Factory(MockHabits)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding.fab.setOnClickListener {
            viewModel.addRandomHabit()
        }
    }
}