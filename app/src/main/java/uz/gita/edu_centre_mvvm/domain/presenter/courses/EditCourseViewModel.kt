package uz.gita.edu_centre_mvvm.domain.presenter.courses

import androidx.lifecycle.LiveData
import uz.gita.edu_centre_mvvm.data.models.CourseData
import uz.gita.edu_centre_mvvm.data.room.entity.CourseEntity

// Created by Jamshid Isoqov an 8/11/2022
interface EditCourseViewModel {

    val backLiveData: LiveData<Unit>

    val updateLiveData: LiveData<Unit>

    val messageLiveData: LiveData<String>

    fun backClick()

    fun editCourse(courseData: CourseData)

    fun editClick()

}