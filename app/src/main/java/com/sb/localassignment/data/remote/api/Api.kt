package com.sb.localassignment.data.remote.api

import com.sb.localassignment.data.model.Job
import com.sb.localassignment.data.model.JobResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("common/jobs")
    suspend fun getJobs(@Query("page") page: Int): JobResponse

}