package uz.gita.edu_centre_mvvm.data.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

// Created by Jamshid Isoqov an 8/11/2022
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: T)

    @Update
    fun update(data: T)

    @Delete
    fun delete(data: T)

}