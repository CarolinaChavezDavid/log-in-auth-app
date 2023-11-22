package com.carolina.log_in_auth_app.ui.data.database.entities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuthToken(user: AuthEntity)

    @Query("SELECT * FROM AuthEntity")
    suspend fun getAuthToken(): AuthEntity?

    @Query("SELECT * FROM AuthEntity")
    fun getAuthTokenFlow(): Flow<AuthEntity?>

    @Update
    suspend fun updateAuthToken(updateUser: AuthEntity)

    @Delete
    suspend fun deleteAuthToken(userToDelete: AuthEntity)
}
