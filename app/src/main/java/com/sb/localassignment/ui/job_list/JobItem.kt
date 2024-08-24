package com.sb.localassignment.ui.job_list

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sb.localassignment.R
 import com.sb.localassignment.data.model.Job


@Composable
fun JobItem(
    job: Job,
    onJobClick: (Job) -> Unit,
    onBookmarkClick: (Job) -> Unit,
    viewModel: JobListViewModel = hiltViewModel()
) {
    val bookMarkState = viewModel.bookmarkedJobs.collectAsState()
    val bookmarked = remember {
        mutableStateOf<Boolean>(bookMarkState.value.any { it.id == job.id })
    }
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onJobClick(job) },
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

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                IconButton(
                    onClick = {
                        // Handle the bookmark click event
                        if (!bookmarked.value) {
                            onBookmarkClick(job)
                            bookmarked.value = true
                            Toast.makeText(context, "Bookmarked", Toast.LENGTH_SHORT)
                                .show()
                        }
                        else {
                            bookmarked.value = false
                            viewModel.deleteBookmark(job.id)
                            Toast.makeText(context, "Bookmark Removed", Toast.LENGTH_SHORT).show()
                            viewModel.fetchBookmarkedJobs()
                        }


                    },
                    modifier = Modifier.align(Alignment.TopEnd) // Align to the end
                ) {
                    Icon(
                        painter = if (bookmarked.value) painterResource(id = R.drawable.bookmark)else painterResource(
                            id = R.drawable.notbookmark
                        ),
                        contentDescription = if (bookmarked.value) "Bookmarked" else "Not Bookmarked"
                    )
                }
            }
        }
    }
}