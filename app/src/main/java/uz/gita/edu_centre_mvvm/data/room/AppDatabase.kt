package uz.gita.edu_centre_mvvm.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.edu_centre_mvvm.data.room.dao.CourseDao
import uz.gita.edu_centre_mvvm.data.room.dao.GroupDao
import uz.gita.edu_centre_mvvm.data.room.entity.CourseEntity
import uz.gita.edu_centre_mvvm.data.room.entity.GroupEntity

// Created by Jamshid Isoqov an 8/11/2022
@Database(entities = [CourseEntity::class, GroupEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun courseDao(): CourseDao

    abstract fun groupDao(): GroupDao

    companion object {
        private lateinit var instance: AppDatabase

        fun init(ctx: Context) {
            instance = Room.databaseBuilder(ctx, AppDatabase::class.java, "edu_centre_mvvm.db")
                .allowMainThreadQueries()
                .build()
        }

        fun getInstance() = instance

    }

}