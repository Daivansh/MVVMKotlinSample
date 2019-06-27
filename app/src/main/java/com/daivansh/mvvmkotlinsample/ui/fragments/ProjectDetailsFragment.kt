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
import com.daivansh.mvvmkotlinsample.databinding.FragmentProjectDetailBinding
import com.daivansh.mvvmkotlinsample.ui.activity.MainActivity
import com.daivansh.mvvmkotlinsample.viewmodel.ProjectDetailsViewModel

class ProjectDetailsFragment: Fragment() {
    private lateinit var binding: FragmentProjectDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =
                DataBindingUtil.inflate(inflater,R.layout.fragment_project_detail,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val projectName= arguments?.getString(MainActivity.PROJECT_ID) ?: ""
        setupData(projectName)
    }

    private fun setupData(projectName: String) {
        val model: ProjectDetailsViewModel = ViewModelProviders.of(this).get(ProjectDetailsViewModel::class.java)
        model.getProjectDetail(projectName).observe(this, Observer<Project> {
            project ->
            binding.project = project
        })
    }


}