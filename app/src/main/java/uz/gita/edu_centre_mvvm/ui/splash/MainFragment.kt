package uz.gita.edu_centre_mvvm.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import uz.gita.edu_centre_mvvm.domain.presenter.main.MainViewModel

class MainFragment : Fragment() {


    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openCourses.observe(this, openCourses)
    }


    private var openCourses = Observer<Unit> {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToCourseListFragment())
    }


}