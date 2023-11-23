package com.carolina.log_in_auth_app.auth.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.carolina.log_in_auth_app.auth.data.database.entities.AuthEntity
import com.carolina.log_in_auth_app.auth.data.database.entities.AuthEntityDao

@Database(
    entities = [AuthEntity::class],
    version = 1,
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun authTokenDao(): AuthEntityDao
}
