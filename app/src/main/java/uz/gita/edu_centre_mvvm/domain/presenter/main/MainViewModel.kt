package uz.gita.edu_centre_mvvm.domain.presenter.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var _openCourses: MutableLiveData<Unit> = MutableLiveData()
    val openCourses: LiveData<Unit> = _openCourses

    init {
        viewModelScope.launch {
            delay(2000)
            _openCourses.postValue(Unit)
        }
    }
}