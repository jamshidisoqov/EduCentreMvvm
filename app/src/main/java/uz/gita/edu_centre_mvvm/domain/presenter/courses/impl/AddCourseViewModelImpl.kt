package uz.gita.edu_centre_mvvm.domain.presenter.courses.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.edu_centre_mvvm.data.room.entity.CourseEntity
import uz.gita.edu_centre_mvvm.domain.presenter.courses.AddCourseViewModel
import uz.gita.edu_centre_mvvm.domain.repository.courses.impl.CourseRepositoryImpl

class AddCourseViewModelImpl : ViewModel(), AddCourseViewModel {

    private var repository = CourseRepositoryImpl.getInstance()

    private var _backLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val backLiveData: LiveData<Unit> = _backLiveData

    private var _addLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val addLiveData: LiveData<Unit> = _addLiveData

    private var _messageLiveData: MutableLiveData<String> = MutableLiveData()
    override val messageLiveData: LiveData<String> = _messageLiveData

    override fun backClick() {
        _backLiveData.postValue(Unit)
    }

    override fun addClick() {
        _addLiveData.postValue(Unit)
    }

    override fun insertCourse(courseEntity: CourseEntity) {
        repository.insertCourse(courseEntity)
        _messageLiveData.postValue("Successfully added")
    }

}