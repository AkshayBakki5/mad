package com.example.usersrecord
import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDAO {
    @Insert
    suspend fun insert(user: User)

}