package br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge.create

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatSpinner
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.control.facade.CreateObjectFacade
import br.ufpb.dcx.apps4society.educapimanager.control.service.RetrofitInitializer
import br.ufpb.dcx.apps4society.educapimanager.model.bean.Challenge
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ContextDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.coroutineContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/**
 * A simple [Fragment] subclass.
 * Use the [ChooseContextOnCreateChallenge.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChooseContextOnCreateChallenge : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var contextos : List<br.ufpb.dcx.apps4society.educapimanager.model.bean.Context>
    private lateinit var listview: ListView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getAllContextsFromService()
         val root = inflater.inflate(R.layout.fragment_nav_choose_context, container, false)

        listview = root.findViewById(R.id.listview_choose)

        return root
    }

    fun getAllContextsFromService(){
        val call = RetrofitInitializer().contextService().findAllContexts()
        call.enqueue(object : Callback<List<br.ufpb.dcx.apps4society.educapimanager.model.bean.Context>> {
            override fun onFailure(
                call: Call<List<br.ufpb.dcx.apps4society.educapimanager.model.bean.Context>>,
                t: Throwable
            ) {
                Toast.makeText(context,"deu merda: "+t.message,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<br.ufpb.dcx.apps4society.educapimanager.model.bean.Context>>,
                response: Response<List<br.ufpb.dcx.apps4society.educapimanager.model.bean.Context>>
            ) {
                contextos = response.body()!!
                initializeSpinner(response.body()!!)
                Toast.makeText(context,"deu tudo certo",Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun updateContext(c:br.ufpb.dcx.apps4society.educapimanager.model.bean.Context){
        val call = RetrofitInitializer().contextService().update(c,c.id)

        call.enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(context,"Deu tudo Errado: "+t.message,Toast.LENGTH_SHORT).show()
                CreateObjectFacade.instance.clearTempChallenge()
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.code() == 200 || response.code() == 204){
                    Toast.makeText(context,"Deu tudo certo",Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

    fun initializeSpinner(contexts: List<br.ufpb.dcx.apps4society.educapimanager.model.bean.Context>){
        val names = arrayListOf<String>()
        for (c:br.ufpb.dcx.apps4society.educapimanager.model.bean.Context in contexts){
            names.add(c.name)
        }
        val adapter = context?.let { ArrayAdapter(it,R.layout.fragment_nav_choose_context,R.id.text_view_list,names) }

        listview.adapter = adapter
    }




}
