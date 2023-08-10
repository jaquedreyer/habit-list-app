package com.dreyer.meutreinodocurso.collections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dreyer.meutreinodocurso.R
import com.dreyer.meutreinodocurso.dummy.MockHabits
import com.google.android.material.divider.MaterialDividerItemDecoration

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

        //Adding decorations to our recycler view
        addingDividerDecoration()
    }
    private fun addingDividerDecoration(){
        //Adding line between items with MaterialDividerItemDecoration
        val divider = MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)

        //Removing the line at the end of the list
        divider.isLastItemDecorated = false

        //chamo resources aqui pra depois poder apenas referenciar abaixo
        //nao colocar as dimensoes hardcoded
        val resources = requireContext().resources

        //Adding start spacing
        divider.dividerInsetStart = resources.getDimensionPixelSize(R.dimen.horizontal_margin)

        //Defining size of the line
        divider.dividerThickness = resources.getDimensionPixelSize(R.dimen.divider_height)
        divider.dividerColor = ContextCompat.getColor(requireContext(), R.color.primary_200)

        binding.habitRecyclerView.addItemDecoration(divider)
    }
    // metodo de espaçamento muito usado entre imagens em um grid ou lista
    private fun addingDividerSpace(){
        binding.habitRecyclerView.addItemDecoration(HabitListItemDecoration(requireContext()))
    }
}