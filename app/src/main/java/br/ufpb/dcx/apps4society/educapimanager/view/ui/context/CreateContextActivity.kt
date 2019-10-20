package br.ufpb.dcx.apps4society.educapimanager.view.ui.context

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.view.ui.context.create.NameCreateContextFragment
import br.ufpb.dcx.apps4society.educapimanager.view.ui.context.create.PhotoCreateContextFragment


class CreateContextActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var navController : NavController
    private lateinit var toolbar : Toolbar
    private var TAG : String = "CreateContextActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_context)
        navController = findNavController(R.id.nav_create_context_host)
        findViewById<Button>(R.id.btnNext).setOnClickListener(this)
        toolbar = findViewById(R.id.toolbar)
        setToolbar()
    }

    private fun setToolbar(){
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        toolbar.setTitle(navController.currentDestination!!.label)

//        toolbar.setNavigationOnClickListener {
//            finish()
//        }

        setSupportActionBar(toolbar)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnNext -> when (navController.currentDestination){
                navController.graph.findNode(R.id.nav_context_name) -> {
                    navController.navigate(R.id.action_nav_context_name_to_nav_context_photo)
                }
                navController.graph.findNode(R.id.nav_context_photo) -> {
                    navController.navigate(R.id.action_nav_context_photo_to_nav_context_video)
                }
                navController.graph.findNode(R.id.nav_context_video) -> navController.navigate(R.id.action_nav_context_video_to_nav_context_audio)
            }
        }
    }

}
