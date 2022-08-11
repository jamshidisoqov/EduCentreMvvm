package uz.gita.edu_centre_mvvm.ui.groups

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.gita.edu_centre_mvvm.R
import uz.gita.edu_centre_mvvm.data.room.entity.GroupEntity
import uz.gita.edu_centre_mvvm.databinding.FragmentGroupListBinding
import uz.gita.edu_centre_mvvm.domain.presenter.groups.GroupListViewModel
import uz.gita.edu_centre_mvvm.domain.presenter.groups.impl.GroupListViewModelImpl
import uz.gita.edu_centre_mvvm.ui.groups.adapter.GroupAdapter

class GroupListFragment : Fragment(R.layout.fragment_group_list) {


    private val viewModel: GroupListViewModel by viewModels<GroupListViewModelImpl>()
    private lateinit var binding: FragmentGroupListBinding
    private val adapter: GroupAdapter by lazy {
        GroupAdapter()
    }
    private val args: GroupListFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getGroups(args.courseData.id)
        viewModel.backLiveData.observe(this, backListener)
        viewModel.openAddGroupLiveData.observe(this, addGroupObserver)
        viewModel.openEditGroupLiveData.observe(this, editGroupObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentGroupListBinding.bind(view)
        binding.apply {
            listGroups.adapter = adapter
            fabAddGroups.setOnClickListener {
                viewModel.addGroupClick()
            }
            imgBack.setOnClickListener {
                viewModel.backClick()
            }

        }
        viewModel.allGroupsLiveData.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
        adapter.setEditListener {
            viewModel.editClicked(it)
        }
        adapter.setItemDeleteListener {
            viewModel.delete(it)
        }
    }


    private val addGroupObserver = Observer<Unit> {
        findNavController().navigate(GroupListFragmentDirections.actionGroupListFragmentToAddGroupFragment())
    }

    private val editGroupObserver = Observer<GroupEntity> {
        findNavController().navigate(
            GroupListFragmentDirections.actionGroupListFragmentToEditGroupFragment(it)
        )
    }

    private val backListener = Observer<Unit> {
        findNavController().popBackStack()
    }


}