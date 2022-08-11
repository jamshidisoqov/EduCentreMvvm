package uz.gita.edu_centre_mvvm.ui.courses.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.edu_centre_mvvm.R
import uz.gita.edu_centre_mvvm.data.models.CourseData
import uz.gita.edu_centre_mvvm.databinding.ListItemCoursesBinding
import uz.gita.edu_centre_mvvm.utils.inflate

// Created by Jamshid Isoqov an 8/11/2022
class CourseAdapter : ListAdapter<CourseData, CourseAdapter.ViewHolder>(itemCallback) {

    private var editListener: ((CourseData) -> Unit)? = null
    private var itemClickListener: ((CourseData) -> Unit)? = null

    fun setEditListener(block: (CourseData) -> Unit) {
        editListener = block
    }

    fun setItemClickListener(block: (CourseData) -> Unit) {
        itemClickListener = block
    }


    inner class ViewHolder(private val binding: ListItemCoursesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.imgCourseEdit.setOnClickListener {
                editListener?.invoke(getItem(adapterPosition))
            }
        }

        fun onBind() {
            binding.apply {
                val data = getItem(adapterPosition)
                tvCourseName.text = data.courseName
                tvGroupCount.text = data.groupCount.toString()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ListItemCoursesBinding.bind(parent.inflate(R.layout.list_item_courses)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()
}

private val itemCallback = object : DiffUtil.ItemCallback<CourseData>() {

    override fun areItemsTheSame(oldItem: CourseData, newItem: CourseData) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CourseData, newItem: CourseData) =
        oldItem.id == newItem.id && oldItem.courseName == newItem.courseName
}