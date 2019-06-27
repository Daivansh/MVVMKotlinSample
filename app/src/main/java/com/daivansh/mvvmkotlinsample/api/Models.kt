package com.daivansh.mvvmkotlinsample.api

import java.util.*

data class Project(var id: Long, val name: String?, var full_name: String?,var owner: User?
                   ,var html_url: String?,val description: String?, var url: String?,var created_at: Date?
                   ,var updated_at: Date?,var pushed_at: Date?,var git_url: String?, var ssh_url: String?
                   ,var clone_url: String?,var svn_url: String?,var homepage: String?,var stargazers_count: Int
                   ,var watchers_count: Int,var language: String?,var has_issues: Boolean,var has_downloads: Boolean
                   ,var has_wiki: Boolean,var has_pages: Boolean,var forks_count: Int,var open_issues_count: Int
                   , var forks: Int,var open_issues: Int,var watchers: Int,var default_branch: String?)


data class User(var login: String?,var id: Long,var avatar_url: String?,var gravatar_id: String?
                ,var url: String?,var html_url: String?,var followers_url: String?
                ,var following_url: String?, var gists_url: String?,var starred_url: String?
                ,var subscriptions_url: String?,var organizations_url: String?,var repos_url: String?
                ,var events_url: String?, var received_events_url: String?,var type: String?,var name: String?
                ,var blog: String?,var location: String?, var email: String?,var public_repos: Int,var public_gists: Int
                ,var followers: Int,var following: Int, var created_at: Date?,var updated_at: Date?)
