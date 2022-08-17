package nl.project.newsreaderapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(private var layoutInflater: (bindingInflater: LayoutInflater) -> VB) :
    Fragment() {
    private var _binding: VB? = null
    lateinit var navController: NavController
    lateinit var mainActivity: MainActivity

    val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // init main activity
        mainActivity = activity as MainActivity
        // get navController already init in the main activity
        navController = mainActivity.navController
        // Inflate the layout for this fragment
        _binding = layoutInflater.invoke(inflater)

        if (_binding == null) {
            throw IllegalArgumentException("Binding cannot be empty")
        }
        return binding.root
    }
}