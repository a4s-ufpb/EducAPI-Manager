package br.ufpb.dcx.apps4society.educapimanager.view

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import androidx.fragment.app.FragmentManager
import br.ufpb.dcx.apps4society.educapimanager.R
import androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.viewpager.widget.ViewPager
import br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge.ChallengeFragment
import br.ufpb.dcx.apps4society.educapimanager.view.ui.context.ContextFragment
import br.ufpb.dcx.apps4society.educapimanager.view.ui.home.HomeFragment
import com.google.android.material.tabs.TabLayout

class NavDrawerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_contact, R.id.nav_logout, R.id.nav_about
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun fillTabMenu() {
        val adapter : TabMenuAdapter = TabMenuAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.add( ContextFragment(),getString(R.string.menu_context))
        adapter.add( ChallengeFragment(),getString(R.string.menu_challenge))

        val vpTabMenu : ViewPager = findViewById(R.id.vpTabMenu)
        vpTabMenu.adapter = adapter
        val tlTabMenu : TabLayout = findViewById(R.id.tlTabMenu)
        tlTabMenu.setupWithViewPager(vpTabMenu)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.nav_drawer, menu)
        fillTabMenu()
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onResume() {
        super.onResume()

    }
}
