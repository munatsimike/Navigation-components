package nl.project.newsreaderapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.viewbinding.ViewBinding
import nl.project.newsreaderapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var _navController: NavController
    private lateinit var binding: ActivityMainBinding
    lateinit var drawerLayout: DrawerLayout

    val navController: NavController
        get() = _navController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // init main activity view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init drawer layout
        drawerLayout = binding.drawerLayout
        // find navController
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        _navController = navHostFragment.navController

        // link controller to the action bar and drawer layout

        NavigationUI.setupActionBarWithNavController(this, _navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    // handle navigate up action from the activity
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout)
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