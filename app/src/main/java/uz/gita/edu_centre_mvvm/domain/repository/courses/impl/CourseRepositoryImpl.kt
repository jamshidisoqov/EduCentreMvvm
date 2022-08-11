package uz.gita.edu_centre_mvvm.domain.repository.courses.impl

import androidx.lifecycle.LiveData
import uz.gita.edu_centre_mvvm.data.models.CourseData
import uz.gita.edu_centre_mvvm.data.room.AppDatabase
import uz.gita.edu_centre_mvvm.data.room.entity.CourseEntity
import uz.gita.edu_centre_mvvm.domain.repository.courses.CourseRepository

class CourseRepositoryImpl private constructor() : CourseRepository {

    private val courseDao = AppDatabase.getInstance().courseDao()

    override fun insertCourse(courseEntity: CourseEntity) = courseDao.insert(courseEntity)

    override fun updateCourse(courseEntity: CourseEntity) = courseDao.update(courseEntity)

    override fun getAllCourses(): LiveData<List<CourseData>> = courseDao.getCourses()

    companion object {
        private lateinit var instance: CourseRepository
        fun getInstance(): CourseRepository {
            if (!Companion::instance.isInitialized) {
                instance = CourseRepositoryImpl()
            }
            return instance
        }
    }

}