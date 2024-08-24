package com.sb.localassignment.data.Local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
 import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {
    @Insert
    suspend fun insert(bookmark: BookmarkDto)

    @Update
    suspend fun update(bookmark: BookmarkDto)

    @Query("SELECT * FROM jobs")
    fun getAllBookmarks(): Flow<List<BookmarkDto>>

    @Query("DELETE FROM jobs WHERE id = :bookmarkId")
    suspend fun deleteById(bookmarkId: Int): Int

}