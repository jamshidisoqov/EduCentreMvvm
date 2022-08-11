package uz.gita.edu_centre_mvvm.domain.presenter.groups

import androidx.lifecycle.LiveData
import uz.gita.edu_centre_mvvm.data.room.entity.GroupEntity

// Created by Jamshid Isoqov an 8/11/2022
interface GroupListViewModel {

    val allGroupsLiveData: LiveData<List<GroupEntity>>

    val backLiveData: LiveData<Unit>

    val openAddGroupLiveData: LiveData<Unit>

    val openEditGroupLiveData: LiveData<GroupEntity>

    fun getGroups(courseId: Int)

    fun backClick()

    fun addGroupClick()

    fun delete(groupEntity: GroupEntity)

    fun editClicked(groupEntity: GroupEntity)

}