package com.daivansh.mvvmkotlinsample.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.daivansh.mvvmkotlinsample.R
import com.daivansh.mvvmkotlinsample.ui.fragments.ProjectDetailsFragment
import com.daivansh.mvvmkotlinsample.ui.fragments.ProjectListFragment

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupProjectListFragment()
    }

    private fun setupProjectListFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_fragment_container,
                ProjectListFragment(), ProjectListFragment.TAG)
            .commit()
    }

    companion object {
        const val PROJECT_ID="Project Id"
    }
    fun showProjectDetailsFragment(projectName: String?) {
        val bundle= Bundle()
        bundle.putString(PROJECT_ID,projectName)
        val projectDetailsFragment= ProjectDetailsFragment()
        projectDetailsFragment.arguments=bundle
        supportFragmentManager.beginTransaction()
            .addToBackStack(ProjectListFragment.TAG)
            .replace(R.id.frame_fragment_container,projectDetailsFragment)
            .commit()
    }


}
