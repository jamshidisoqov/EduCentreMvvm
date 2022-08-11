package uz.gita.edu_centre_mvvm.ui.groups.add

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.gita.edu_centre_mvvm.R
import uz.gita.edu_centre_mvvm.data.room.entity.GroupEntity
import uz.gita.edu_centre_mvvm.databinding.FragmentAddGroupBinding
import uz.gita.edu_centre_mvvm.domain.presenter.groups.AddGroupViewModel
import uz.gita.edu_centre_mvvm.domain.presenter.groups.impl.AddGroupViewModelImpl

class AddGroupFragment : Fragment(R.layout.fragment_add_group) {

    private val viewModel: AddGroupViewModel by viewModels<AddGroupViewModelImpl>()
    private lateinit var binding: FragmentAddGroupBinding
    private val args: AddGroupFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.backLiveData.observe(this, backListener)
        viewModel.addGroupLiveData.observe(this, addGroupObserver)
        viewModel.messageLiveData.observe(this, messageObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAddGroupBinding.bind(view)
        binding.imgBack.setOnClickListener {
            viewModel.backClick()
        }
        binding.btnAddGroup.setOnClickListener {
            viewModel.addClicked()
        }
    }


    private val backListener = Observer<Unit> {
        findNavController().popBackStack()
    }
    private val addGroupObserver = Observer<Unit> {
        val name = binding.edGroupName.text.toString()
        val mentorName = binding.edMentorName.text.toString()
        viewModel.addGroup(GroupEntity(0, name, mentorName, args.courseId))
        findNavController().popBackStack()
    }
    private val messageObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }


}