package uz.gita.edu_centre_mvvm.ui.groups.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.edu_centre_mvvm.R
import uz.gita.edu_centre_mvvm.data.room.entity.GroupEntity
import uz.gita.edu_centre_mvvm.databinding.ListItemGroupBinding
import uz.gita.edu_centre_mvvm.utils.inflate

// Created by Jamshid Isoqov an 8/11/2022
class GroupAdapter : ListAdapter<GroupEntity, GroupAdapter.ViewHolder>(itemCallback) {

    private var editListener: ((GroupEntity) -> Unit)? = null
    private var deleteClickListener: ((GroupEntity) -> Unit)? = null

    fun setEditListener(block: (GroupEntity) -> Unit) {
        editListener = block
    }

    fun setItemDeleteListener(block: (GroupEntity) -> Unit) {
        deleteClickListener = block
    }


    inner class ViewHolder(private val binding: ListItemGroupBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.apply {
                imgGroupDelete.setOnClickListener {
                    deleteClickListener?.invoke(getItem(adapterPosition))
                }
                imgGroupEdit.setOnClickListener {
                    editListener?.invoke(getItem(adapterPosition))
                }
            }
        }

        fun onBind() {
            val data = getItem(adapterPosition)
            binding.apply {
                tvGroupName.text = data.groupName
                tvMentorName.text = data.mentorName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ListItemGroupBinding.bind(parent.inflate(R.layout.list_item_group)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()
}

private val itemCallback = object : DiffUtil.ItemCallback<GroupEntity>() {
    override fun areItemsTheSame(oldItem: GroupEntity, newItem: GroupEntity) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: GroupEntity, newItem: GroupEntity) =
        oldItem.id == newItem.id && oldItem.groupName == newItem.groupName
}