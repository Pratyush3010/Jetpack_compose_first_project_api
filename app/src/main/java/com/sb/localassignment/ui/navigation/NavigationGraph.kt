package com.sb.localassignment.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sb.localassignment.ui.bookmark_list.BookMarkDetailsScreen
import com.sb.localassignment.ui.bookmark_list.BookmarkScreen
import com.sb.localassignment.ui.job_list.JobListViewModel
import com.sb.localassignment.ui.job_list.JobScreen
import com.sb.localassignment.ui.jobdetail_list.JobDetailScreen

@Composable
fun NavigationGraph(navController: NavHostController, viewModel: JobListViewModel = hiltViewModel()) {
    NavHost(navController, startDestination = BottomNavItem.Jobs.screen_route) {
        composable(BottomNavItem.Jobs.screen_route) {
            JobScreen(navController,viewModel)  // Pass navController if needed
        }
        composable(BottomNavItem.Bookmarks.screen_route) {
            BookmarkScreen(navController,viewModel)  // Pass navController if needed
        }
        composable("jobDetail/{jobId}") { backStackEntry ->
             val job by viewModel.selectedJob.collectAsState()
            if(job==null) Log.e("TAG","job is null")
                job?.let {
                    JobDetailScreen(job = it, navController = navController)
                }
        }
        composable("bookmarkDetails") { backStackEntry ->
             val job by viewModel.selectedBookmark.collectAsState()
            if(job==null) Log.e("TAG","job is null")
            job?.let {
                BookMarkDetailsScreen(job = it, navController = navController)
            }
        }
    }
}
