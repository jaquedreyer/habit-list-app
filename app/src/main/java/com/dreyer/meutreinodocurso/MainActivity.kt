package com.dreyer.meutreinodocurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.dreyer.meutreinodocurso.collections.HabitListViewModel
import com.dreyer.meutreinodocurso.databinding.ActivityMainBinding
import com.dreyer.meutreinodocurso.dummy.MockHabits

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

    //instanciar aqui o viewmodel
    private val viewModel : HabitListViewModel by viewModels {
        HabitListViewModel.Factory(MockHabits)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root) //root é o coordinatorLayout, activity_main.xml
        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {
            viewModel.addRandomHabit()
        }
    }
}