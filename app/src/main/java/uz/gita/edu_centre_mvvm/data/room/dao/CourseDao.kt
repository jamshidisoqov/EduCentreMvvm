package uz.gita.edu_centre_mvvm.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import uz.gita.edu_centre_mvvm.data.models.CourseData
import uz.gita.edu_centre_mvvm.data.room.entity.CourseEntity

// Created by Jamshid Isoqov an 8/11/2022
@Dao
interface CourseDao : BaseDao<CourseEntity> {

    @Query("SELECT courses.id,courses.course_name,COUNT(courses.id) FROM courses,groups WHERE courses.id=groups.course_id ")
    fun getCourses(): LiveData<List<CourseData>>

}