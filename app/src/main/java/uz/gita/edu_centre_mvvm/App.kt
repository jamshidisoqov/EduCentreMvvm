package uz.gita.edu_centre_mvvm

import android.app.Application
import uz.gita.edu_centre_mvvm.data.room.AppDatabase

// Created by Jamshid Isoqov an 8/11/2022
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppDatabase.init(this)
    }

}