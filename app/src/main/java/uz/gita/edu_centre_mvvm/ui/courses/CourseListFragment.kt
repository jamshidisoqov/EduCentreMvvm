package uz.gita.edu_centre_mvvm.ui.courses

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import uz.gita.edu_centre_mvvm.R
import uz.gita.edu_centre_mvvm.data.models.CourseData
import uz.gita.edu_centre_mvvm.databinding.FragmentCourseListBinding
import uz.gita.edu_centre_mvvm.domain.presenter.courses.CourseListViewModel
import uz.gita.edu_centre_mvvm.domain.presenter.courses.impl.CourseListViewModelImpl
import uz.gita.edu_centre_mvvm.ui.courses.adapters.CourseAdapter

class CourseListFragment : Fragment(R.layout.fragment_course_list) {


    private val viewModel: CourseListViewModel by viewModels<CourseListViewModelImpl>()

    private val adapter: CourseAdapter by lazy {
        CourseAdapter()
    }
    private lateinit var binding: FragmentCourseListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openAddCourseLiveData.observe(this, addCourseObserver)
        viewModel.openEditLiveData.observe(this, editCourseObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentCourseListBinding.bind(view)

        binding.listCourses.adapter = adapter

        viewModel.allCourses.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        adapter.setEditListener {
            viewModel.editClicked(it)
        }
        adapter.setItemClickListener {
            viewModel.addClicked()
        }

        binding.fabAddCourse.setOnClickListener {
            viewModel.addClicked()
        }


    }


    private val addCourseObserver = Observer<Unit> {
        findNavController().navigate(CourseListFragmentDirections.actionCourseListFragmentToAddCourseFragment())
    }

    private val editCourseObserver = Observer<CourseData> {
        findNavController().navigate(
            CourseListFragmentDirections.actionCourseListFragmentToEditCourseFragment(
                it
            )
        )
    }


}