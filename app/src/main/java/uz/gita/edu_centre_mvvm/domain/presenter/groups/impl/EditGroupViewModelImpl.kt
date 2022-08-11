package uz.gita.edu_centre_mvvm.domain.presenter.groups.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.edu_centre_mvvm.data.room.entity.GroupEntity
import uz.gita.edu_centre_mvvm.domain.presenter.groups.EditGroupViewModel
import uz.gita.edu_centre_mvvm.domain.repository.groups.impl.GroupRepositoryImpl

class EditGroupViewModelImpl : ViewModel(), EditGroupViewModel {

    private val repository = GroupRepositoryImpl.getInstance()

    private var _backLiveData: MediatorLiveData<Unit> = MediatorLiveData()
    override val backLiveData: LiveData<Unit> = _backLiveData

    private var _updateLiveData: MediatorLiveData<Unit> = MediatorLiveData()
    override val updateLiveData: LiveData<Unit> = _updateLiveData

    private var _messageLiveData: MutableLiveData<String> = MutableLiveData()
    override val messageLiveData: LiveData<String> = _messageLiveData

    override fun backClick() {
        _backLiveData.postValue(Unit)
    }

    override fun editGroup(groupEntity: GroupEntity) {
        repository.updateGroup(groupEntity)
    }

    override fun editClick() {
        _updateLiveData.postValue(Unit)
    }

}