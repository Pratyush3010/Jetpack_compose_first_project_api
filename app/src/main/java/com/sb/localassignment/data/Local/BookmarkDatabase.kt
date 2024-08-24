package com.sb.localassignment.data.Local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
 import com.sb.localassignment.utils.Converters

@Database(
    entities = [BookmarkDto::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class BookmarkDatabase: RoomDatabase() {

    abstract val dao: BookmarkDao
}