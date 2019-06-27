package com.daivansh.mvvmkotlinsample.ui.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daivansh.mvvmkotlinsample.R
import com.daivansh.mvvmkotlinsample.api.Project
import com.daivansh.mvvmkotlinsample.callbacks.ShowProjectDetailCallback
import com.daivansh.mvvmkotlinsample.databinding.FragmentProjectListBinding
import com.daivansh.mvvmkotlinsample.ui.activity.MainActivity
import com.daivansh.mvvmkotlinsample.ui.adapter.ProjectListAdapter
import com.daivansh.mvvmkotlinsample.viewmodel.ProjectListViewModel

class ProjectListFragment : Fragment(), ShowProjectDetailCallback {

    private var adapter: ProjectListAdapter =
        ProjectListAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentProjectListBinding
                =DataBindingUtil.inflate(inflater, R.layout.fragment_project_list,container,false)
        binding.rvProjectList.adapter = adapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeProjectList()
    }

    private fun observeProjectList() {
        val model: ProjectListViewModel = ViewModelProviders.of(this).get(ProjectListViewModel::class.java)
        model.getProjectsList().observe(this, Observer<List<Project>>{
                users ->
            adapter.updateList(users)
        } )
    }

    override fun showDetails(projectName: String?) {
        (activity as MainActivity).showProjectDetailsFragment(projectName)
    }

    companion object {
        const val TAG="ProjectListFragment"
    }

}