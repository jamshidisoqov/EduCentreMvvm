package uz.gita.edu_centre_mvvm.domain.repository.groups.impl

import androidx.lifecycle.LiveData
import uz.gita.edu_centre_mvvm.data.room.AppDatabase
import uz.gita.edu_centre_mvvm.data.room.entity.GroupEntity
import uz.gita.edu_centre_mvvm.domain.repository.groups.GroupRepository

class GroupRepositoryImpl private constructor() : GroupRepository {

    private val groupDao = AppDatabase.getInstance().groupDao()

    override fun insertGroup(groupEntity: GroupEntity) = groupDao.insert(groupEntity)

    override fun updateGroup(groupEntity: GroupEntity) = groupDao.update(groupEntity)

    override fun deleteGroup(groupEntity: GroupEntity) = groupDao.delete(groupEntity)

    override fun getAllGroupByCourse(courseId: Int): LiveData<List<GroupEntity>> =
        groupDao.getGroupsByGroup(courseId)

    companion object {
        private lateinit var instance: GroupRepository

        fun getInstance(): GroupRepository {
            if (!Companion::instance.isInitialized) {
                instance = GroupRepositoryImpl()
            }
            return instance
        }

    }
}