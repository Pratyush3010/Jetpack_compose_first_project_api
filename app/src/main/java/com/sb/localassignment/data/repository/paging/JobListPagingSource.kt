package com.sb.localassignment.data.repository.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sb.localassignment.data.model.Job
import com.sb.localassignment.data.remote.api.Api
import retrofit2.HttpException
import java.io.IOException

class JobListPagingSource(
        private val remoteDataSource: Api,
    ) : PagingSource<Int, Job>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Job> {
        return try {
            val currentPage = params.key ?: 1
            val jobList = remoteDataSource.getJobs(
                page = currentPage
            )
            Log.d("from pagging","Joblist $currentPage list> ${jobList.results}")
            LoadResult.Page(
                data = jobList.results,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (jobList.results.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Job>): Int? {
        return state.anchorPosition
    }
}

