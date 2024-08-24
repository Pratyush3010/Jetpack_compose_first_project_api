package com.sb.localassignment.ui.job_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
 import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
 import com.sb.localassignment.data.model.Job

@Composable
fun JobScreen(
    navController: NavController,
    viewModel: JobListViewModel = hiltViewModel()
) {
    val jobList: LazyPagingItems<Job> = viewModel.jobListState.collectAsLazyPagingItems()
    Column(modifier = Modifier.fillMaxSize()
        .padding(top = 50.dp, bottom = 50.dp)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            items(jobList.itemCount) { job ->
                job?.let {
                    JobItem(
                        jobList[job]!!,
                        onJobClick = { job ->
                            viewModel.updateSelectedJob(job)
                            navController.navigate("jobDetail/${job.id}")
                        }, onBookmarkClick = { bookmark ->
                            viewModel.insertBookmark(bookmark)
                        }
                    )
                }
            }

            jobList.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        item { CircularProgressIndicator() }
                    }

                    loadState.refresh is LoadState.Error -> {
                        val e = jobList.loadState.refresh as LoadState.Error
                        item { Text(text = "Error: ${e.error.localizedMessage}") }
                    }

                    loadState.append is LoadState.Error -> {
                        val e = jobList.loadState.append as LoadState.Error
                        item { Text(text = "Error: ${e.error.localizedMessage}") }
                        item { Text(text = "Restart") }

                    }
                }
            }
        }
    }
}

