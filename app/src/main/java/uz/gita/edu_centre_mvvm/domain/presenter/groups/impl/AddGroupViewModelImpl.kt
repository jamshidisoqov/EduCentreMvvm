package uz.gita.edu_centre_mvvm.domain.presenter.groups.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.edu_centre_mvvm.data.room.entity.GroupEntity
import uz.gita.edu_centre_mvvm.domain.presenter.groups.AddGroupViewModel
import uz.gita.edu_centre_mvvm.domain.repository.groups.impl.GroupRepositoryImpl

class AddGroupViewModelImpl : ViewModel(), AddGroupViewModel {

    private val repository = GroupRepositoryImpl.getInstance()

    private var _backLiveData: MediatorLiveData<Unit> = MediatorLiveData()
    override val backLiveData: LiveData<Unit> = _backLiveData

    private var _addGroupLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val addGroupLiveData: LiveData<Unit> = _addGroupLiveData

    private var _messageLiveData: MutableLiveData<String> = MutableLiveData()
    override val messageLiveData: LiveData<String> = _messageLiveData

    override fun addGroup(groupEntity: GroupEntity) {
        repository.insertGroup(groupEntity)
    }

    override fun addClicked() {
        _addGroupLiveData.postValue(Unit)
    }

    override fun backClick() {
        _backLiveData.postValue(Unit)
    }

}