package com.budgete.teamapp.database.dao

import androidx.room.*
import com.budgete.teamapp.database.entities.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    suspend fun login(username: String, password: String): User?

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Delete
    suspend fun deleteUser(user: User)
}
