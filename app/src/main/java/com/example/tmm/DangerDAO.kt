package com.example.tmm

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface DangerDAO {
    @Insert(onConflict = REPLACE)
    fun insert(danger: DangerEntity)

    @Query("SELECT * FROM danger")
    fun getAll(): List<DangerEntity>

    @Delete
    fun delete(danger: DangerEntity)

}