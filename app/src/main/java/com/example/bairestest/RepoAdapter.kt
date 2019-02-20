package com.example.bairestest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.bairestest.databinding.ItemRepoBinding
import com.example.bairestest.models.Repo

class RepoAdapter(private val callback:(pos: Int) -> Unit): androidx.recyclerview.widget.RecyclerView.Adapter<RepoViewHolder>() {

    var data = mutableListOf<Repo>()


    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.binding?.repo = data[position]
        holder.binding?.root?.tag = position
        holder.binding?.handler = this
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RepoViewHolder(parent.inflate(R.layout.item_repo))

    override fun getItemCount(): Int = data.size

    fun onRepoClick(pos: Int) {
        callback(pos)
    }
}

class RepoViewHolder(view: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
    val binding: ItemRepoBinding? = DataBindingUtil.bind(view)
}


fun ViewGroup.inflate(layout:Int) = LayoutInflater.from(context).inflate(layout, this, false)
