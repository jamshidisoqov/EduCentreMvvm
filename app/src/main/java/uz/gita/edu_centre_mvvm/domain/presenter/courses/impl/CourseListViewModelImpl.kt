package uz.gita.edu_centre_mvvm.domain.presenter.courses.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.edu_centre_mvvm.data.models.CourseData
import uz.gita.edu_centre_mvvm.domain.presenter.courses.CourseListViewModel
import uz.gita.edu_centre_mvvm.domain.repository.courses.impl.CourseRepositoryImpl

class CourseListViewModelImpl : ViewModel(), CourseListViewModel {

    private val repository = CourseRepositoryImpl.getInstance()

    private var _allCourses: MutableLiveData<List<CourseData>> = MutableLiveData()
    override val allCourses: LiveData<List<CourseData>> = _allCourses

    private var _openAddCourseLiveData: MediatorLiveData<Unit> = MediatorLiveData()
    override val openAddCourseLiveData: LiveData<Unit> = _openAddCourseLiveData

    private var _openEditLiveData: MutableLiveData<CourseData> = MutableLiveData()
    override val openEditLiveData: LiveData<CourseData> = _openEditLiveData

    override fun addClicked() {
        _openAddCourseLiveData.postValue(Unit)
    }

    override fun getCourses() {
        _openAddCourseLiveData.addSource(repository.getAllCourses()) {
            _allCourses.postValue(it)
        }
    }

    override fun editClicked(courseData: CourseData) {
        _openEditLiveData.postValue(courseData)
    }

}