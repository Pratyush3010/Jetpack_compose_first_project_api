package com.sb.localassignment.domain.repository

  import androidx.paging.PagingData
import com.sb.localassignment.data.model.Job
import com.sb.localassignment.data.model.JobResponse
import kotlinx.coroutines.flow.Flow

interface JobListRepository {
      fun getJobs(): Flow<PagingData<Job>>

}