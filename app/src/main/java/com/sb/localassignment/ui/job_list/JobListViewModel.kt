package com.sb.localassignment.ui.job_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sb.localassignment.data.Local.BookmarkDto
 import com.sb.localassignment.data.model.Job
import com.sb.localassignment.domain.usecase.BookMarkUseCase
import com.sb.localassignment.domain.usecase.GetJobListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JobListViewModel @Inject constructor(
    private val getJobListUseCase: GetJobListUseCase,
    private val getBookmarkUseCase: BookMarkUseCase
) : ViewModel() {

    val jobListState: Flow<PagingData<Job>> = getJobListUseCase().cachedIn(viewModelScope)


    private val _bookmarkedJobs = MutableStateFlow<List<BookmarkDto>>(emptyList())
    val bookmarkedJobs: StateFlow<List<BookmarkDto>> = _bookmarkedJobs.asStateFlow()

    private val _selectedJob = MutableStateFlow<Job?>(null)
    val selectedJob: StateFlow<Job?> = _selectedJob


    private val _selectedBookmark = MutableStateFlow<BookmarkDto?>(null)
    val selectedBookmark: StateFlow<BookmarkDto?> = _selectedBookmark



    init {
        fetchBookmarkedJobs()
        Log.d("TAG","ViewModel init")
    }

    fun insertBookmark(job: Job) {
        viewModelScope.launch {
            getBookmarkUseCase.insertJob(job)
            Log.e("JobListViewModel", "inserted")

        }
    }

    fun fetchBookmarkedJobs() {
        viewModelScope.launch {
            getBookmarkUseCase.getBookmarkList()
                .onEach { jobs ->
                    _bookmarkedJobs.value = jobs
                    Log.e("JobListViewModel", "$jobs")

                }
                .catch { e ->
                    Log.e("JobListViewModel", "Error fetching bookmarked jobs", e)
                }
                .launchIn(viewModelScope)
        }
    }

    fun updateSelectedJob(job: Job) {
        _selectedJob.value = job
        Log.d("Tag","val selected job ${_selectedJob.value}")
    }

    fun deleteBookmark(jobId: Int) {
        viewModelScope.launch {
            getBookmarkUseCase.deleteJob(jobId)
        }
    }
    fun updateSelectedBookmark(job: BookmarkDto){
        _selectedBookmark.value = job
    }

}