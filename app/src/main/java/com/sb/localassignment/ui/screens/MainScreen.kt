package com.sb.localassignment.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.sb.localassignment.ui.job_list.JobListViewModel
import com.sb.localassignment.ui.navigation.BottomNavigationBar
import com.sb.localassignment.ui.navigation.NavigationGraph

 @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
 @Composable
@Preview
fun MainScreen(viewModel: JobListViewModel= hiltViewModel()) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
                BottomNavigationBar(navController = navController,   modifier = Modifier.navigationBarsPadding())
        }
    ) {
             NavigationGraph(navController = navController,viewModel)

            }
}
