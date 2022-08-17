package nl.project.newsreaderapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(private var layoutInflater: (bindingInflater: LayoutInflater) -> VB) :
    Fragment() {
    private var _binding: VB? = null

    val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = layoutInflater.invoke(inflater)

        if (_binding == null) {
            throw IllegalArgumentException("Binding cannot be empty")
        }

        return binding.root
    }

}