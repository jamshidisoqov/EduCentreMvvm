package uz.gita.edu_centre_mvvm.ui.courses.add

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import uz.gita.edu_centre_mvvm.R
import uz.gita.edu_centre_mvvm.data.room.entity.CourseEntity
import uz.gita.edu_centre_mvvm.databinding.FragmentAddCourseBinding
import uz.gita.edu_centre_mvvm.domain.presenter.courses.AddCourseViewModel
import uz.gita.edu_centre_mvvm.domain.presenter.courses.impl.AddCourseViewModelImpl

class AddCourseFragment : Fragment(R.layout.fragment_add_course) {

    private val viewModel: AddCourseViewModel by viewModels<AddCourseViewModelImpl>()

    private lateinit var binding: FragmentAddCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.backLiveData.observe(this, backListener)
        viewModel.addLiveData.observe(this, addCourseObserver)
        viewModel.messageLiveData.observe(this, messageObserver)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAddCourseBinding.bind(view)

        binding.apply {
            imgBack.setOnClickListener {
                viewModel.backClick()
            }
            btnAddCourse.setOnClickListener {
                viewModel.addClick()
            }
        }
    }

    private val backListener = Observer<Unit> {
        findNavController().popBackStack()
    }
    private val addCourseObserver = Observer<Unit> {
        val name = binding.edCourseName.text.toString()
        viewModel.insertCourse(CourseEntity(0, name))
        findNavController().popBackStack()
    }
    private val messageObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }


}