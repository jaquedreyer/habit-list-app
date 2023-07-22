package com.dreyer.meutreinodocurso.collections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dreyer.meutreinodocurso.dummy.MockHabits

/**
 * A [Fragment] that displays a list of habits.
 */

class HabitListFragment : Fragment () {

    private lateinit var adapter: HabitListAdapter //var de iniciacao tardia, algum momento vou iniciar ela

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = HabitListAdapter() //iniciei aqui
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //set the adapter
        binding.habitRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.habitRecyclerView.adapter = adapter
        //updating the list of habits
        adapter.updateHabits(MockHabits.habitItemList)
    }
}