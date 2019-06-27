package com.daivansh.mvvmkotlinsample.ui.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.daivansh.mvvmkotlinsample.R
import com.daivansh.mvvmkotlinsample.api.Project
import com.daivansh.mvvmkotlinsample.callbacks.ShowProjectDetailCallback
import com.daivansh.mvvmkotlinsample.databinding.ProjectListItemBinding


class ProjectListAdapter(var showProjectDetailsCallback: ShowProjectDetailCallback) : RecyclerView.Adapter<ProjectListAdapter.ProjectListViewHolder>() {
    private var projectsList: List<Project>? = emptyList()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProjectListViewHolder {
        val binding: ProjectListItemBinding = DataBindingUtil
            .inflate(LayoutInflater.from(p0.context), R.layout.project_list_item,p0,false)
        return ProjectListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return projectsList?.size ?: 0
    }

    override fun onBindViewHolder(p0: ProjectListViewHolder, p1: Int) {
        p0.binding.project=projectsList?.get(p1)
        p0.binding.callback=showProjectDetailsCallback
    }

    fun updateList(list: List<Project>?){
        projectsList = list
        notifyDataSetChanged()
    }

    inner class ProjectListViewHolder(var binding: ProjectListItemBinding) : RecyclerView.ViewHolder(binding.root)
}