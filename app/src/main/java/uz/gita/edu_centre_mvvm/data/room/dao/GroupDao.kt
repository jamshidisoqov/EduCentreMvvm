package uz.gita.edu_centre_mvvm.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import uz.gita.edu_centre_mvvm.data.room.entity.GroupEntity

// Created by Jamshid Isoqov an 8/11/2022
@Dao
interface GroupDao : BaseDao<GroupEntity> {
    @Query("SELECT*FROM groups WHERE course_id=:courseId")
    fun getGroupsByGroup(courseId: Int): LiveData<List<GroupEntity>>
}