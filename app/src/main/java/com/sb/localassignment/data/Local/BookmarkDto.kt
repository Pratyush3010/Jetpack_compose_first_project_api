package com.sb.localassignment.data.Local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sb.localassignment.data.model.*

@Entity(tableName = "jobs")
data class BookmarkDto(
    @PrimaryKey val id: Int,
    val title: String? = null,
    val type: Int? = null,
    val primary_details: PrimaryDetails? = null,
    val fee_details: FeeDetails? = null,
    val job_tags: List<JobTag>? = null,
    val job_type: Int? = null,
    val job_category_id: Int? = null,
    val qualification: Int? = null,
    val experience: Int? = null,
    val shift_timing: Int? = null,
    val job_role_id: Int? = null,
    val salary_max: Int? = null,
    val salary_min: Int? = null,
    val city_location: Int? = null,
    val locality: Int? = null,
    val premium_till: String? = null,
    val content: String? = null,
    val company_name: String? = null,
    val advertiser: Int? = null,
    val button_text: String? = null,
    val custom_link: String? = null,
    val amount: String? = null,
    val views: Int? = null,
    val shares: Int? = null,
    val fb_shares: Int? = null,
    val is_bookmarked: Boolean? = null,
    val is_applied: Boolean? = null,
    val is_owner: Boolean? = null,
    val updated_on: String? = null,
    val whatsapp_no: String? = null,
    val contact_preference: ContactPreference? = null,
    val created_on: String? = null,
    val is_premium: Boolean? = null,
    val creatives: List<Creative>? = null,
    val videos: List<String>? = null, // Adjust as necessary if videos have a specific structure
    val locations: List<Location>? = null,
    val tags: List<String>? = null, // Adjust as necessary if tags have a specific structure
    val contentV3: ContentV3? = null,
    val status: Int? = null,
    val expire_on: String? = null,
    val job_hours: String? = null,
    val openings_count: Int? = null,
    val job_role: String? = null,
    val other_details: String? = null,
    val job_category: String? = null,
    val num_applications: Int? = null,
    val enable_lead_collection: Boolean? = null,
    val is_job_seeker_profile_mandatory: Boolean? = null,
    val translated_content: Map<String, String>? = null
)
