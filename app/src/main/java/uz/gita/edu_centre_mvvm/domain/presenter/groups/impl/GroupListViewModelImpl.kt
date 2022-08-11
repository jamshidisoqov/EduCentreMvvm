package uz.gita.edu_centre_mvvm.domain.presenter.groups.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.edu_centre_mvvm.data.room.entity.GroupEntity
import uz.gita.edu_centre_mvvm.domain.presenter.groups.GroupListViewModel
import uz.gita.edu_centre_mvvm.domain.repository.groups.impl.GroupRepositoryImpl

class GroupListViewModelImpl : ViewModel(), GroupListViewModel {


    private val repository = GroupRepositoryImpl.getInstance()

    private var _allGroupsLiveData: MutableLiveData<List<GroupEntity>> = MutableLiveData()
    override val allGroupsLiveData: LiveData<List<GroupEntity>> = _allGroupsLiveData

    private var _backLiveData: MediatorLiveData<Unit> = MediatorLiveData()
    override val backLiveData: LiveData<Unit> = _backLiveData

    private var _openAddGroupLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val openAddGroupLiveData: LiveData<Unit> = _openAddGroupLiveData

    private var _openEditGroupLiveData: MutableLiveData<GroupEntity> = MutableLiveData()
    override val openEditGroupLiveData: LiveData<GroupEntity> = _openEditGroupLiveData

    override fun getGroups(courseId: Int) {
        _backLiveData.addSource(repository.getAllGroupByCourse(courseId)) {
            _allGroupsLiveData.postValue(it)
        }
    }

    override fun backClick() {
        _backLiveData.postValue(Unit)
    }

    override fun addGroupClick() {
        _openAddGroupLiveData.postValue(Unit)
    }

    override fun delete(groupEntity: GroupEntity) {
        repository.deleteGroup(groupEntity)
    }

    override fun editClicked(groupEntity: GroupEntity) {
        _openEditGroupLiveData.postValue(groupEntity)
    }

}