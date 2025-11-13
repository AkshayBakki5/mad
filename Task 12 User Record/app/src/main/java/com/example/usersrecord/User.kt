package com.example.usersrecord

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CSEG")
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid: Int=0,
    val userName: String,
    val userPhone: String
)
