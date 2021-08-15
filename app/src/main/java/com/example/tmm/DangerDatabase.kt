package com.example.tmm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(DangerEntity::class), version = 1)
abstract class DangerDatabase : RoomDatabase() {
    abstract fun memoDAO(): DangerDAO

    companion object {
        var INSTANCE : DangerDatabase? = null

        fun getInstance(context: Context): DangerDatabase? {
            if(INSTANCE == null){
                synchronized(DangerDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        DangerDatabase::class.java, "danger.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}