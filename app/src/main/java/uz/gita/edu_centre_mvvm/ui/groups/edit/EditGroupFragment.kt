package uz.gita.edu_centre_mvvm.ui.groups.edit

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.gita.edu_centre_mvvm.R
import uz.gita.edu_centre_mvvm.databinding.FragmentEditGroupBinding
import uz.gita.edu_centre_mvvm.domain.presenter.groups.EditGroupViewModel
import uz.gita.edu_centre_mvvm.domain.presenter.groups.impl.EditGroupViewModelImpl

class EditGroupFragment : Fragment(R.layout.fragment_edit_group) {

    private val viewModel: EditGroupViewModel by viewModels<EditGroupViewModelImpl>()
    private lateinit var binding: FragmentEditGroupBinding
    private val args: EditGroupFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.backLiveData.observe(this, backListener)
        viewModel.messageLiveData.observe(this, messageObserver)
        viewModel.updateLiveData.observe(this, editCourseObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentEditGroupBinding.bind(view)

        binding.apply {
            edGroupName.setText(args.groupData.groupName)
            edMentorName.setText(args.groupData.mentorName)

            imgBack.setOnClickListener {
                viewModel.backClick()
            }
            btnEditGroup.setOnClickListener {
                viewModel.editClick()
            }
        }
    }

    private val backListener = Observer<Unit> {
        findNavController().popBackStack()
    }
    private val editCourseObserver = Observer<Unit> {
        val name = binding.edGroupName.text.toString()
        val mentorName = binding.edMentorName.text.toString()
        viewModel.editGroup(args.groupData.copy(groupName = name, mentorName = mentorName))
    }
    private val messageObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }

}