package uz.gita.edu_centre_mvvm.domain.presenter.courses

import androidx.lifecycle.LiveData
import uz.gita.edu_centre_mvvm.data.models.CourseData
import uz.gita.edu_centre_mvvm.data.room.entity.CourseEntity

// Created by Jamshid Isoqov an 8/11/2022
interface CourseListViewModel {

    val allCourses: LiveData<List<CourseData>>

    val openAddCourseLiveData: LiveData<Unit>

    val openEditLiveData: LiveData<CourseData>

    fun addClicked()

    fun getCourses()

    fun editClicked(courseEntity: CourseData)

}