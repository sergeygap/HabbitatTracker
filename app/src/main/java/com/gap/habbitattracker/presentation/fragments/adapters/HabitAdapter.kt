package com.gap.habbitattracker.presentation.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.gap.habbitattracker.R
import com.gap.habbitattracker.data.HabitRepositoryImpl
import com.gap.habbitattracker.databinding.ItemHabitBinding
import com.gap.habbitattracker.domain.useCases.GetListHabitsUseCase
import com.gap.habbitattracker.domain.useCases.GetHabitByIdUseCase
import com.gap.habbitattracker.presentation.fragments.DetailHabitFragment

class HabitAdapter() : RecyclerView.Adapter<HabitViewHolder>() {
    private val habitRepositoryImpl = HabitRepositoryImpl
    private val getListHabitUseCase = GetListHabitsUseCase(habitRepositoryImpl)
    private val getHabitById = GetHabitByIdUseCase(habitRepositoryImpl)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val binding = ItemHabitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HabitViewHolder(binding)
    }


    override fun onBindViewHolder(viewHolder: HabitViewHolder, position: Int) {
        val habit = getHabitById(position)
        with(viewHolder.binding) {
            tvName.text = habit.name
            tvDescription.text = habit.description
            tvPriority.text = habit.priority
            tvType.text = habit.type
            tvCountReady.text = habit.countReady.toString()
            tvCountPeriod.text = habit.period.toString()
        }


        viewHolder.itemView.setOnClickListener {
            (viewHolder.itemView.context as? AppCompatActivity)?.let { activity ->
                activity.supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.main_fragment_container,
                        DetailHabitFragment()
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }

    }

    override fun getItemCount(): Int = getListHabitUseCase().size

}