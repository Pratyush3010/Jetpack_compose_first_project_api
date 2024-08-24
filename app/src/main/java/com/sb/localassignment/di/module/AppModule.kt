package com.sb.localassignment.di.module

import com.sb.localassignment.data.Local.BookmarkDao
import com.sb.localassignment.data.remote.api.Api
import com.sb.localassignment.data.repository.BookMarkRepositoryImpl
import com.sb.localassignment.data.repository.JobListRepositoryImpl
import com.sb.localassignment.domain.repository.BookmarkRepository
import com.sb.localassignment.domain.repository.JobListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideJobRepository(api: Api): JobListRepository {
        return JobListRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideBookmarkRepository(dao: BookmarkDao): BookmarkRepository {
        return BookMarkRepositoryImpl(dao)
    }

}