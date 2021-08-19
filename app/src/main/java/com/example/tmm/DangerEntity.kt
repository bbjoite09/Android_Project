package com.example.tmm

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "danger")
data class DangerEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    var lineNum: Int,
    val stationName: String
    ){}