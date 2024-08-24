package com.sb.localassignment.domain.usecase

import androidx.paging.PagingData
import com.sb.localassignment.data.Local.BookmarkDto
 import com.sb.localassignment.data.model.Job
import com.sb.localassignment.domain.repository.BookmarkRepository
import com.sb.localassignment.domain.repository.JobListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookMarkUseCase @Inject constructor(
    private val bookMarkRepository: BookmarkRepository
) {

    fun getBookmarkList(): Flow<List<BookmarkDto>> {
        return bookMarkRepository.getJobs()
    }

    suspend fun insertJob(job: Job) {
        bookMarkRepository.insertJob(job)
    }

    suspend fun deleteJob(jobId:Int):Int{
        return bookMarkRepository.deleteJob(jobId)
    }
}