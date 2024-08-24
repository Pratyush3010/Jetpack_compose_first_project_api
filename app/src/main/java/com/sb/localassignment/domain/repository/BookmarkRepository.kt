package com.sb.localassignment.domain.repository

  import com.sb.localassignment.data.Local.BookmarkDto
  import com.sb.localassignment.data.model.Job
import kotlinx.coroutines.flow.Flow

interface BookmarkRepository {
    suspend fun insertJob(job: Job)
    fun getJobs(): Flow<List<BookmarkDto>>
    suspend fun deleteJob(jobId:Int):Int
}