package uz.gita.edu_centre_mvvm.domain.presenter.groups

import androidx.lifecycle.LiveData
import uz.gita.edu_centre_mvvm.data.room.entity.GroupEntity

// Created by Jamshid Isoqov an 8/11/2022
interface EditGroupViewModel {

    val backLiveData: LiveData<Unit>

    val updateLiveData: LiveData<Unit>

    val messageLiveData: LiveData<String>

    fun backClick()

    fun editGroup(groupEntity: GroupEntity)

    fun editClick()

}