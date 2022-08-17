package nl.project.newsreaderapp

import android.os.Bundle
import android.view.View
import nl.project.newsreaderapp.databinding.HomeFragmentBinding

class HomeFragment :BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.plyBtn.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_favouriteFragment)
        }
    }
}