package uz.gita.edu_centre_mvvm.domain.repository.courses

import androidx.lifecycle.LiveData
import uz.gita.edu_centre_mvvm.data.models.CourseData
import uz.gita.edu_centre_mvvm.data.room.entity.CourseEntity

// Created by Jamshid Isoqov an 8/11/2022
interface CourseRepository {

    fun insertCourse(courseEntity: CourseEntity)

    fun updateCourse(courseEntity: CourseEntity)

    fun getAllCourses(): LiveData<List<CourseData>>

}