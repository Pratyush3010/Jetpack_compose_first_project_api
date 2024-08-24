package com.sb.localassignment.ui.navigation

import com.sb.localassignment.R

sealed class BottomNavItem(val title: String, val screen_route: String, val iconId: Int) {
    object Jobs : BottomNavItem("Jobs", "jobs", R.drawable.job_seeker)
    object Bookmarks : BottomNavItem("Bookmarks", "bookmarks", R.drawable.notbookmark)
}

