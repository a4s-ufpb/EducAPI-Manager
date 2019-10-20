package br.ufpb.dcx.apps4society.educapimanager.view.ui.context

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
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
import br.ufpb.dcx.apps4society.educapimanager.control.facade.CreateObjectFacade
import br.ufpb.dcx.apps4society.educapimanager.control.service.RetrofitInitializer
import br.ufpb.dcx.apps4society.educapimanager.model.Context
import br.ufpb.dcx.apps4society.educapimanager.view.ui.context.create.NameCreateContextFragment
import br.ufpb.dcx.apps4society.educapimanager.view.ui.context.create.PhotoCreateContextFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


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

        setSupportActionBar(toolbar)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnNext -> when (navController.currentDestination){
                navController.graph.findNode(R.id.nav_context_name) -> navController.navigate(R.id.action_nav_context_name_to_nav_context_photo)

                navController.graph.findNode(R.id.nav_context_photo) -> navController.navigate(R.id.action_nav_context_photo_to_nav_context_video)

                navController.graph.findNode(R.id.nav_context_video) -> navController.navigate(R.id.action_nav_context_video_to_nav_context_audio)

                navController.graph.findNode(R.id.nav_context_audio) -> navController.navigate(R.id.action_nav_context_audio_to_nav_context_sucess)

                navController.graph.findNode(R.id.nav_context_sucess) -> {
                    Log.i(TAG, CreateObjectFacade.instance.tempContext.toString())
                    var call : Call<Void> = RetrofitInitializer().contextService().insert(CreateObjectFacade.instance.tempContext)

                    call.enqueue(object: Callback<Void?> {
                        override fun onResponse(call: Call<Void?>?, response: Response<Void?>?) {
                            if(response?.isSuccessful!!){
                                Log.i(TAG, "SUCESSO!!")
                                Toast.makeText(applicationContext, "Contexto criado com sucesso!", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(applicationContext, "Erro ao criar contexto!", Toast.LENGTH_SHORT).show()
                                Log.i(TAG, "NÃO SUCESSO!!")
                            }
                        }

                        override fun onFailure(call: Call<Void?>?, t: Throwable?) {
                            Toast.makeText(applicationContext, "Erro ao se comunicar com o serviço!", Toast.LENGTH_SHORT).show()
                            Log.i(TAG, "DEU ERRADO NO SERVICE!! " + t?.message + call.toString())
                        }
                    })

                    finish()
                }
            }
        }
    }

}
