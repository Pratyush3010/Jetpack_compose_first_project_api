package com.sb.localassignment.data.repository

  import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sb.localassignment.data.model.Job
import com.sb.localassignment.data.model.JobResponse
import com.sb.localassignment.data.remote.api.Api
import com.sb.localassignment.data.repository.paging.JobListPagingSource
import com.sb.localassignment.domain.repository.JobListRepository
import com.sb.localassignment.utils.Constants.MAX_PAGE_SIZE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JobListRepositoryImpl @Inject constructor(
    val apiService: Api
) : JobListRepository {

    override fun getJobs(): Flow<PagingData<Job>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_PAGE_SIZE, prefetchDistance = 2),
            pagingSourceFactory = {
                JobListPagingSource(apiService)
            }
        ).flow
    }


}