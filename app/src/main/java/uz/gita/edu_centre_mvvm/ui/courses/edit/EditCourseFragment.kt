package uz.gita.edu_centre_mvvm.ui.courses.edit

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.gita.edu_centre_mvvm.databinding.FragmentEditCourseBinding
import uz.gita.edu_centre_mvvm.domain.presenter.courses.EditCourseViewModel
import uz.gita.edu_centre_mvvm.domain.presenter.courses.impl.EditCourseViewModelImpl

class EditCourseFragment : Fragment() {

    private val viewModel: EditCourseViewModel by viewModels<EditCourseViewModelImpl>()
    private lateinit var binding: FragmentEditCourseBinding
    private val args: EditCourseFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.backLiveData.observe(this, backListener)
        viewModel.messageLiveData.observe(this, messageObserver)
        viewModel.updateLiveData.observe(this, editCourseObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentEditCourseBinding.bind(view)

        binding.apply {
            edCourseName.setText(args.courseData.courseName)

            imgBack.setOnClickListener {
                viewModel.backClick()
            }
            btnEditCourse.setOnClickListener {
                viewModel.editClick()
            }
        }

    }

    private val backListener = Observer<Unit> {
        findNavController().popBackStack()
    }
    private val editCourseObserver = Observer<Unit> {
        val name = binding.edCourseName.text.toString()
        viewModel.editCourse(args.courseData.copy(courseName = name))
    }
    private val messageObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }
}