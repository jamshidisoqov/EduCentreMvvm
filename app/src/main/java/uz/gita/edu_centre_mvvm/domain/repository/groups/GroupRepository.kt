package uz.gita.edu_centre_mvvm.domain.repository.groups

import androidx.lifecycle.LiveData
import uz.gita.edu_centre_mvvm.data.room.entity.GroupEntity

// Created by Jamshid Isoqov an 8/11/2022
interface GroupRepository {

    fun insertGroup(groupEntity: GroupEntity)

    fun updateGroup(groupEntity: GroupEntity)

    fun deleteGroup(groupEntity: GroupEntity)

    fun getAllGroupByCourse(courseId:Int): LiveData<List<GroupEntity>>

}

