package nl.project.newsreaderapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.viewbinding.ViewBinding
import nl.project.newsreaderapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController
    lateinit var binding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // init main activity view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // find navController
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        // link controller to the action bar
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    // handle navigate up action from the activity
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}