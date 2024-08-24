package com.sb.localassignment.ui.bookmark_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.sb.localassignment.data.Local.BookmarkDto
import com.sb.localassignment.data.model.Job
 import com.sb.localassignment.ui.job_list.JobListViewModel


@Composable
fun  BookmarkScreen(
    navController: NavController,
    viewModel: JobListViewModel = hiltViewModel()
) {
    val bookMarkedList = viewModel.bookmarkedJobs.collectAsState()
     Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, bottom = 50.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            items(bookMarkedList.value.size) { job ->
                job?.let {
                    BookMarkItem(
                      bookMarkedList.value.getOrNull(job)!!
                        ,viewModel,navController
                    )
                }
            }


        }
    }
}

@Composable
fun BookMarkItem(job: BookmarkDto, viewModel: JobListViewModel = hiltViewModel(), navController:NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                viewModel.updateSelectedBookmark(job)
                navController.navigate("bookmarkDetails")
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = job.title ?: "NULL",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Location: ${job.primary_details?.Place ?: "Unknown Place"}",
                style = MaterialTheme.typography.bodyMedium
            )
            val mxsal = job.salary_max ?: 0
            val mnsal = job.salary_min ?: 0
            Text(
                text = "Salary: $mnsal - $mxsal",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Contact: ${job.whatsapp_no ?: "NULL"}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
