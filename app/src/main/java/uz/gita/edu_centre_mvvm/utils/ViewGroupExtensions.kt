package uz.gita.edu_centre_mvvm.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// Created by Jamshid Isoqov an 7/21/2022

fun ViewGroup.inflate(resId: Int): View {
    return LayoutInflater.from(this.context).inflate(resId, this, false)
}
