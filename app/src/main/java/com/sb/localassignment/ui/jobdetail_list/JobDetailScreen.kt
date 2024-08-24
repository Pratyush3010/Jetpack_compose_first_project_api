package com.sb.localassignment.ui.jobdetail_list

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
import com.sb.localassignment.data.model.Job

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobDetailScreen(job: Job, navController: NavController) {
    Log.d("TAG", "Working $job")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Job Details") },
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
                .padding(innerPadding)
                .padding(start = 16.dp, end = 16.dp, bottom = 60.dp)
                .verticalScroll(scrollState)
        ) {
            // Display all fields from the Job data class using Cards for better visual grouping
            JobDetailCard(title = "Job ID", content = job.id?.toString() ?: "Not provided")
            JobDetailCard(title = "Title", content = job.title ?: "Not provided")
            JobDetailCard(title = "Type", content = job.type?.toString() ?: "Not provided")
            JobDetailCard(title = "Primary Details", content = job.primary_details?.Place ?: "Not provided")
            JobDetailCard(title = "Salary", content = "${job.salary_max ?: "Not specified"} - ${job.salary_min ?: "Not specified"}")
            JobDetailCard(title = "Company Name", content = job.company_name ?: "Not provided")
            JobDetailCard(title = "Job Tags", content = job.job_tags?.joinToString(", ") { it.value } ?: "Not provided")
            JobDetailCard(title = "Job Type", content = job.job_type?.toString() ?: "Not provided")
            JobDetailCard(title = "Job Category ID", content = job.job_category_id?.toString() ?: "Not provided")
            JobDetailCard(title = "Qualification", content = job.qualification?.toString() ?: "Not provided")
            JobDetailCard(title = "Experience", content = job.experience?.toString() ?: "Not provided")
            JobDetailCard(title = "Shift Timing", content = job.shift_timing?.toString() ?: "Not provided")
            JobDetailCard(title = "Job Role ID", content = job.job_role_id?.toString() ?: "Not provided")
            JobDetailCard(title = "City Location", content = (job.city_location ?: "Not provided").toString())
            JobDetailCard(title = "Locality", content = (job.locality ?: "Not provided").toString())
            JobDetailCard(title = "Premium Till", content = job.premium_till ?: "Not provided")
            JobDetailCard(title = "Content", content = job.content ?: "Not provided")
            JobDetailCard(title = "Advertiser", content = job.advertiser?.toString() ?: "Not provided")
            JobDetailCard(title = "Button Text", content = job.button_text ?: "Not provided")
            JobDetailCard(title = "Custom Link", content = job.custom_link ?: "Not provided")
            JobDetailCard(title = "Amount", content = job.amount?.toString() ?: "Not provided")
            JobDetailCard(title = "Views", content = job.views?.toString() ?: "Not provided")
            JobDetailCard(title = "Shares", content = job.shares?.toString() ?: "Not provided")
            JobDetailCard(title = "Facebook Shares", content = job.fb_shares?.toString() ?: "Not provided")
            JobDetailCard(title = "Is Bookmarked", content = job.is_bookmarked?.toString() ?: "Not provided")
            JobDetailCard(title = "Is Applied", content = job.is_applied?.toString() ?: "Not provided")
            JobDetailCard(title = "Is Owner", content = job.is_owner?.toString() ?: "Not provided")
            JobDetailCard(title = "Updated On", content = job.updated_on ?: "Not provided")
            JobDetailCard(title = "WhatsApp Number", content = job.whatsapp_no ?: "Not provided")
            JobDetailCard(title = "Contact Preference", content = job.contact_preference?.preference?.toString() ?: "Not provided")
            JobDetailCard(title = "Created On", content = job.created_on ?: "Not provided")
            JobDetailCard(title = "Is Premium", content = job.is_premium?.toString() ?: "Not provided")
            JobDetailCard(title = "Creatives", content = job.creatives?.joinToString(", ") { it.file } ?: "Not provided")
            JobDetailCard(title = "Videos", content = job.videos?.joinToString(", ") ?: "Not provided")
            JobDetailCard(title = "Locations", content = job.locations?.joinToString(", ") { it.locale } ?: "Not provided")
            JobDetailCard(title = "Tags", content = job.tags?.joinToString(", ") ?: "Not provided")
            JobDetailCard(title = "Status", content = job.status?.toString() ?: "Not provided")
            JobDetailCard(title = "Expire On", content = job.expire_on ?: "Not provided")
            JobDetailCard(title = "Job Hours", content = job.job_hours ?: "Not provided")
            JobDetailCard(title = "Openings Count", content = job.openings_count?.toString() ?: "Not provided")
            JobDetailCard(title = "Job Role", content = job.job_role ?: "Not provided")
            JobDetailCard(title = "Other Details", content = job.other_details ?: "Not provided")
            JobDetailCard(title = "Job Category", content = job.job_category ?: "Not provided")
            JobDetailCard(title = "Number of Applications", content = job.num_applications?.toString() ?: "Not provided")
            JobDetailCard(title = "Enable Lead Collection", content = job.enable_lead_collection?.toString() ?: "Not provided")
            JobDetailCard(title = "Is Job Seeker Profile Mandatory", content = job.is_job_seeker_profile_mandatory?.toString() ?: "Not provided")
            JobDetailCard(title = "Translated Content", content = job.translated_content?.entries?.joinToString(", ") { "${it.key}: ${it.value}" } ?: "Not provided")
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
