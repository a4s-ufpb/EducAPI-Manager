package br.ufpb.dcx.apps4society.educapimanager.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge.ChallengeFragment
import br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge.CreateChallengeActivity
import br.ufpb.dcx.apps4society.educapimanager.view.ui.context.ContextFragment
import br.ufpb.dcx.apps4society.educapimanager.view.ui.context.CreateContextActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar


class NavDrawerActivity() : AppCompatActivity(), View.OnClickListener{

    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var navController : NavController
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var toolbar : Toolbar
    private lateinit var navView : NavigationView

    private var TAG : String = "NavDrawerActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_drawer)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //val fab: FloatingActionButton = findViewById(R.id.fab)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment)
//      Passing each menu ID as a set of Ids because each
//      menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_contact, R.id.nav_logout, R.id.nav_about,R.id.nav_search
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        var fab : FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.nav_drawer, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onClick(v: View?) {
        Log.i(TAG,"CLICK")
        when(v?.id){
            R.id.fab -> when (navController.currentDestination){
                navController.graph.findNode(R.id.nav_home) -> {
                    if(currentFragmentInHomeViewPage is ContextFragment){
                        Log.i(TAG,"CONTEXT")
                        val intent = Intent(applicationContext, CreateContextActivity::class.java)
                        startActivity(intent)
                        Log.i(TAG,"CONTEXT")
                    }else if(currentFragmentInHomeViewPage is ChallengeFragment){
                        Log.i(TAG,"CHALLENGE")
                        val intent = Intent(applicationContext, CreateChallengeActivity::class.java)
                        startActivity(intent)
                        Log.i(TAG,"CHALLENGE")
                    }else{
                        val intent = Intent(applicationContext, CreateContextActivity::class.java)
                        startActivity(intent)
                        Log.i(TAG,"CONTEXT")
                    }
                }
            }
        }
    }

    companion object {
        private var currentFragmentInHomeViewPage : Fragment? = null

        fun OnChangeViewPagerFragment(hook : OnNavDrawerListener){
            currentFragmentInHomeViewPage = hook.onChangeFragment()
        }
    }

    interface OnNavDrawerListener{
        fun onChangeFragment() : Fragment;
    }

}
