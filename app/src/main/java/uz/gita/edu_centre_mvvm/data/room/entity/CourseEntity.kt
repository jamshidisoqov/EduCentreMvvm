package uz.gita.edu_centre_mvvm.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Created by Jamshid Isoqov an 8/11/2022
@Entity(tableName = "courses")
data class CourseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "course_name")
    val courseName: String
)