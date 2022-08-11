package uz.gita.edu_centre_mvvm.data.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.parcelize.Parcelize
import uz.gita.edu_centre_mvvm.data.room.entity.CourseEntity

// Created by Jamshid Isoqov an 8/11/2022
@Parcelize
data class CourseData(
    val id: Int,
    @ColumnInfo(name = "course_name")
    val courseName: String,
    val groupCount: Int = 0
) : Parcelable {
    fun toCourseEntity() = CourseEntity(id, courseName)
}
