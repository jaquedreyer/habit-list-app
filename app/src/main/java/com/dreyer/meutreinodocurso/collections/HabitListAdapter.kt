package com.dreyer.meutreinodocurso.collections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


/**
 * RecyclerView Adapter (*Adapter is a design pattern) for displaying a list of habits.
 *
 * The UI is based on the [HabitItemBinding].OBS=FAZER AINDA
 *  We use the [HabitItem] as a model for the binding.
 */

class HabitListAdapter : RecyclerView.Adapter<HabitListAdapter.ViewHolder>() {

    private val asyncListDiffer: AsyncListDiffer<HabitItem> = AsyncListDiffer(this, DiffCallback)

    //sobreescrever 3 metodos/fun do recyclerview adapter abaixo
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HabitItemBinding.inflate(layoutInflater, parent, false)
        return RecyclerView.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.bind(asyncListDiffer.currentList[position])
    }

    override fun getItemCount(): Int = asyncListDiffer.currentList.size

    /** Update the list of habitats
     * @see [https://medium.com/quark-works/android-asynclistdiffer-recycleviews-best-friend-365f75d84f4]
     */
    fun updateHabits(habits: List<HabitItem>) {
        asyncListDiffer.submitList(habits)
    }

    //create a new instance of ViewHolder that contains the layout xml of a list item
    class ViewHolder(private val binding: HabitItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(habit: HabitItem) {
            binding.titleTextView.text = habit.title
            binding.completeCheckBox.isChecked = habit.isCompleted
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<HabitItem>() {
        override fun areItemsTheSame(oldItem: HabitItem, newItem: HabitItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HabitItem, newItem: HabitItem): Boolean {
            return oldItem == newItem
        }
    }


}
