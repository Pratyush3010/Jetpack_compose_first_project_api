package com.sb.localassignment.domain.usecase

import androidx.paging.PagingData
import com.sb.localassignment.data.model.Job
import com.sb.localassignment.domain.repository.JobListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetJobListUseCase @Inject constructor(
    private val jobRepository: JobListRepository
) {

    operator fun invoke(): Flow<PagingData<Job>> {
        return jobRepository.getJobs()
    }
}