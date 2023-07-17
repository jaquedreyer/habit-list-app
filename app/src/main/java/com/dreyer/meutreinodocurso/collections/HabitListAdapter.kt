package com.dreyer.meutreinodocurso.collections

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import javax.net.ssl.SSLSessionBindingEvent

/**
 * Descrever aqui essa primeira parte do adapter
 */

class HabitListAdapter : RecyclerView.Adapter<HabitListAdapter.ViewHolder>() {

    //private val asyncListDiffer: AsyncListDiffer.......


    //create a new instance of ViewHolder that contains the layout xml of a list item
    //vai 'segurar' a view p depois ser inflada,ou seja, segura o layout xml depois so precisa mudar a info dentro
    class ViewHolder(private val binding: HabitItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: HabitItem) {
            binding.titleTextView.text = habit.title
            binding.completeCheckBox.isChecked = habit.isCompleted
        }
    }


}
