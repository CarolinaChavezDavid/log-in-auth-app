package com.carolina.log_in_auth_app.auth.data.database

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    companion object {
        @VisibleForTesting
        val APP_DATABASE_NAME = "AuthDb"
    }

    @Provides
    @Singleton
    fun databaseProvider(@ApplicationContext appContext: Context): AppDatabase =
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            APP_DATABASE_NAME,
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .addMigrations().build()
}
