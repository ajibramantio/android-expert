package com.dicoding.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dicoding.core.data.source.local.entity.FilmEntity
import com.dicoding.core.utils.DataConverter

@Database(entities = [FilmEntity::class],
    version = 1,
    exportSchema = false)

@TypeConverters(DataConverter::class)
abstract class FilmDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao

}