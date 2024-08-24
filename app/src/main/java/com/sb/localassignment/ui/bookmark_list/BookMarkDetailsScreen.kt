package com.sb.localassignment.ui.bookmark_list

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sb.localassignment.R
import com.sb.localassignment.data.Local.BookmarkDto

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookMarkDetailsScreen(job: BookmarkDto?, navController: NavController) {
    if (job == null) {
        // Handle null job scenario
        Text(text = "No job details available")
        return
    }

    Log.d("TAG", "Working $job")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Bookmark Job Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.left_arrow),
                            modifier = Modifier.size(30.dp),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Apply the padding provided by Scaffold
                .padding(start = 16.dp, end = 16.dp, bottom = 60.dp)
                .verticalScroll(scrollState) // Enable vertical scrolling
        ) {
            // Display all fields from the Job data class using Cards for better visual grouping
            JobDetailCard(title = "Job ID", content = job.id?.toString() ?: "N/A")
            JobDetailCard(title = "Title", content = job.title ?: "N/A")
            JobDetailCard(title = "Type", content = job.type?.toString() ?: "N/A")
            JobDetailCard(title = "Primary Details", content = job.primary_details?.Place ?: "Not provided")
            JobDetailCard(title = "Salary", content = "${job.salary_max ?: "Not specified"} - ${job.salary_min ?: "N/A"}")
            JobDetailCard(title = "Company Name", content = job.company_name ?: "N/A")
            JobDetailCard(title = "Job Tags", content = job.job_tags?.joinToString(", ") { it.value } ?: "N/A")
            JobDetailCard(title = "Job Type", content = job.job_type?.toString() ?: "N/A")
            JobDetailCard(title = "Job Category ID", content = job.job_category_id?.toString() ?: "N/A")
            JobDetailCard(title = "Qualification", content = job.qualification?.toString() ?: "N/A")
            JobDetailCard(title = "Experience", content = job.experience?.toString() ?: "N/A")
            JobDetailCard(title = "Shift Timing", content = job.shift_timing?.toString() ?: "N/A")
            JobDetailCard(title = "Job Role ID", content = job.job_role_id?.toString() ?: "N/A")
            JobDetailCard(title = "City Location", content = (job.city_location ?: "N/A").toString())
            JobDetailCard(title = "Locality", content = (job.locality ?: "N/A").toString())
            JobDetailCard(title = "Premium Till", content = job.premium_till ?: "N/A")
            JobDetailCard(title = "Content", content = job.content ?: "N/A")
            JobDetailCard(title = "Advertiser", content = job.advertiser?.toString() ?: "N/A")
            JobDetailCard(title = "Button Text", content = job.button_text ?: "N/A")
            JobDetailCard(title = "Custom Link", content = job.custom_link ?: "N/A")
            JobDetailCard(title = "Amount", content = job.amount?.toString() ?: "N/A")
            JobDetailCard(title = "Views", content = job.views?.toString() ?: "N/A")
            JobDetailCard(title = "Shares", content = job.shares?.toString() ?: "N/A")
            JobDetailCard(title = "Facebook Shares", content = job.fb_shares?.toString() ?: "N/A")
            JobDetailCard(title = "Is Bookmarked", content = job.is_bookmarked?.toString() ?: "N/A")
            JobDetailCard(title = "Is Applied", content = job.is_applied?.toString() ?: "N/A")
            JobDetailCard(title = "Is Owner", content = job.is_owner?.toString() ?: "N/A")
            JobDetailCard(title = "Updated On", content = job.updated_on ?: "N/A")
            JobDetailCard(title = "WhatsApp Number", content = job.whatsapp_no ?: "Not provided")
            JobDetailCard(title = "Contact Preference", content = job.contact_preference?.preference?.toString() ?: "N/A")
            JobDetailCard(title = "Created On", content = job.created_on ?: "N/A")
            JobDetailCard(title = "Is Premium", content = job.is_premium?.toString() ?: "N/A")
            JobDetailCard(title = "Creatives", content = job.creatives?.joinToString(", ") { it.file } ?: "N/A")
            JobDetailCard(title = "Videos", content = job.videos?.joinToString(", ") ?: "N/A")
            JobDetailCard(title = "Locations", content = job.locations?.joinToString(", ") { it.locale } ?: "N/A")
            JobDetailCard(title = "Tags", content = job.tags?.joinToString(", ") ?: "N/A")
            JobDetailCard(title = "Status", content = job.status?.toString() ?: "N/A")
            JobDetailCard(title = "Expire On", content = job.expire_on ?: "N/A")
            JobDetailCard(title = "Job Hours", content = job.job_hours ?: "N/A")
            JobDetailCard(title = "Openings Count", content = job.openings_count?.toString() ?: "N/A")
            JobDetailCard(title = "Job Role", content = job.job_role ?: "N/A")
            JobDetailCard(title = "Other Details", content = job.other_details ?: "N/A")
            JobDetailCard(title = "Job Category", content = job.job_category ?: "N/A")
            JobDetailCard(title = "Number of Applications", content = job.num_applications?.toString() ?: "N/A")
            JobDetailCard(title = "Enable Lead Collection", content = job.enable_lead_collection?.toString() ?: "N/A")
            JobDetailCard(title = "Is Job Seeker Profile Mandatory", content = job.is_job_seeker_profile_mandatory?.toString() ?: "N/A")
            JobDetailCard(title = "Translated Content", content = job.translated_content?.entries?.joinToString(", ") { "${it.key}: ${it.value}" } ?: "N/A")
        }
    }
}

@Composable
fun JobDetailCard(title: String, content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start
            )
        }
    }
}
