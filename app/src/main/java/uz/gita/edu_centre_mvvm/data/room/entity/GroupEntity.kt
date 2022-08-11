package uz.gita.edu_centre_mvvm.data.room.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

// Created by Jamshid Isoqov an 8/11/2022
@Parcelize
@Entity(
    tableName = "groups",
    foreignKeys = [
        ForeignKey(
            entity = CourseEntity::class,
            parentColumns = ["id"],
            childColumns = ["course_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class GroupEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "group_name")
    val groupName: String,
    @ColumnInfo(name = "mentor_name")
    val mentorName: String,
    @ColumnInfo(name = "course_id")
    val courseId: Int
) : Parcelable