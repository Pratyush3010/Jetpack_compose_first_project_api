package com.sb.localassignment.data.repository

import com.sb.localassignment.data.Local.BookmarkDao
import com.sb.localassignment.data.Local.BookmarkDto
import com.sb.localassignment.data.model.*
import com.sb.localassignment.domain.repository.BookmarkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookMarkRepositoryImpl @Inject constructor(
    private val bookMarkDao: BookmarkDao
) : BookmarkRepository {

    override suspend fun insertJob(job: Job) {
        val primaryDetails = job.primary_details?:PrimaryDetails(
            Place = "Unknown Place",
            Salary = "Unknown Salary",
            Job_Type = "Unknown Type",
            Experience = "Unknown Experience",
            Fees_Charged = "Unknown Fees",
            Qualification = "Unknown Qualification"
        )
        val bookmarkDto = BookmarkDto(
            id = job.id,
            title = job.title ?: "Unknown Title",
            type = job.type ?: 0,
            primary_details = primaryDetails,
            fee_details = job.fee_details ?: FeeDetails(V3 = emptyList()),
            job_tags = job.job_tags ?: emptyList(),
            job_type = job.job_type ?: 0,
            job_category_id = job.job_category_id ?: 0,
            qualification = job.qualification ?: 0,
            experience = job.experience ?: 0,
            shift_timing = job.shift_timing ?: 0,
            job_role_id = job.job_role_id ?: 0,
            salary_max = job.salary_max ?: 0,
            salary_min = job.salary_min ?: 0,
            city_location = job.city_location ?: 0,
            locality = job.locality ?: 0,
            premium_till = job.premium_till ?: "N/A",
            content = job.content ?: "No Content",
            company_name = job.company_name ?: "Unknown Company",
            advertiser = job.advertiser ?: 0,
            button_text = job.button_text ?: "Default Button Text",
            custom_link = job.custom_link ?: "No Link",
            amount = job.amount ?: "0",
            views = job.views ?: 0,
            shares = job.shares ?: 0,
            fb_shares = job.fb_shares ?: 0,
            is_bookmarked = job.is_bookmarked ?: false,
            is_applied = job.is_applied ?: false,
            is_owner = job.is_owner ?: false,
            updated_on = job.updated_on ?: "Unknown Date",
            whatsapp_no = job.whatsapp_no ?: "No Number",
            contact_preference = job.contact_preference ?: ContactPreference(
                preference = 0,
                whatsapp_link = "No Link",
                preferred_call_start_time = "00:00",
                preferred_call_end_time = "23:59"
            ),
            created_on = job.created_on ?: "Unknown Date",
            is_premium = job.is_premium ?: false,
            creatives = job.creatives ?: emptyList(),
            videos = job.videos ?: emptyList(),
            locations = job.locations ?: emptyList(),
            tags = job.tags ?: emptyList(),
            contentV3 = job.contentV3 ?: ContentV3(V3 = emptyList()),
            status = job.status ?: 0,
            expire_on = job.expire_on ?: "Unknown Date",
            job_hours = job.job_hours ?: "Not Specified",
            openings_count = job.openings_count ?: 0,
            job_role = job.job_role ?: "Unknown Role",
            other_details = job.other_details ?: "No Details",
            job_category = job.job_category ?: "Unknown Category",
            num_applications = job.num_applications ?: 0,
            enable_lead_collection = job.enable_lead_collection ?: false,
            is_job_seeker_profile_mandatory = job.is_job_seeker_profile_mandatory ?: false,
            translated_content = job.translated_content ?: emptyMap()
        )
        bookMarkDao.insert(bookmarkDto)
    }

    override fun getJobs(): Flow<List<BookmarkDto>> {
        return bookMarkDao.getAllBookmarks()
    }

    override suspend fun deleteJob(jobId: Int): Int {
        return bookMarkDao.deleteById(jobId)
    }
}
