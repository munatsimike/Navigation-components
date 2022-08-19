package nl.project.newsreaderapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import nl.project.newsreaderapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var _navController: NavController
    private lateinit var binding: ActivityMainBinding

    val navController: NavController
        get() = _navController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // init main activity view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //init drawer layout
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        _navController = navHostFragment.navController


        // link controller to the action bar
        setupActionBarWithNavController(navController)
        binding.bottomNav.setupWithNavController(navController)
    }

    // handle navigate up action from the activity
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    // handle menu item selected- navigate to appropriate destination
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(_navController)
    }

    // inflate the overflow menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return true
    }
}