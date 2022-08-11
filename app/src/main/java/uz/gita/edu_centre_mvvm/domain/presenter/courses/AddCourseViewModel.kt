package uz.gita.edu_centre_mvvm.domain.presenter.courses

import androidx.lifecycle.LiveData
import uz.gita.edu_centre_mvvm.data.room.entity.CourseEntity

// Created by Jamshid Isoqov an 8/11/2022
interface AddCourseViewModel {

    val backLiveData: LiveData<Unit>

    val addLiveData: LiveData<Unit>

    val messageLiveData: LiveData<String>

    fun backClick()

    fun addClick()

    fun insertCourse(courseEntity: CourseEntity)


}