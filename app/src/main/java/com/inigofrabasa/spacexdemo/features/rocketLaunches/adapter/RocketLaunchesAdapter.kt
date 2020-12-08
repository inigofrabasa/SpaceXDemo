package com.inigofrabasa.spacexdemo.features.rocketLaunches.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.inigofrabasa.spacexdemo.databinding.ItemRocketLaunchBinding
import com.inigofrabasa.spacexdemo.features.rocketLaunches.model.view.LaunchesView
import javax.inject.Inject

class RocketLaunchesAdapter
@Inject constructor() : RecyclerView.Adapter<RocketLaunchesAdapter.ViewHolder>() {

    private var collection: MutableList<LaunchesView> = mutableListOf()

    fun setCollection(collection: MutableList<LaunchesView>){
        this.collection = collection
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
            lateinit var view : ViewDataBinding
            view = ItemRocketLaunchBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return ViewHolder(view)
        }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(collection[position])
    }

    override fun getItemCount() = collection.size

    class ViewHolder(private var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(launchesView : LaunchesView) {
            (binding as ItemRocketLaunchBinding).apply {
                this.launch = launchesView
            }
        }
    }
 }