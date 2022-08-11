package uz.gita.edu_centre_mvvm.domain.presenter.courses.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.edu_centre_mvvm.data.models.CourseData
import uz.gita.edu_centre_mvvm.domain.presenter.courses.EditCourseViewModel
import uz.gita.edu_centre_mvvm.domain.repository.courses.impl.CourseRepositoryImpl

class EditCourseViewModelImpl : ViewModel(), EditCourseViewModel {

    private var repository = CourseRepositoryImpl.getInstance()

    private var _backLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val backLiveData: LiveData<Unit> = _backLiveData

    private var _updateLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val updateLiveData: LiveData<Unit> = _updateLiveData

    private var _messageLiveData: MutableLiveData<String> = MutableLiveData()
    override val messageLiveData: LiveData<String> = _messageLiveData

    override fun backClick() {
        _backLiveData.postValue(Unit)
    }

    override fun editCourse(courseData: CourseData) {
        repository.updateCourse(courseData.toCourseEntity())
        _messageLiveData.postValue("Successfully Updated")
    }

    override fun editClick() {
        _updateLiveData.postValue(Unit)
    }

}