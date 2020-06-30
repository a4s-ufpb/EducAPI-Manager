package br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.control.facade.CreateObjectFacade
import br.ufpb.dcx.apps4society.educapimanager.control.service.RetrofitInitializer
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ContextDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ChooseContextOnCreateChallenge : Fragment() {
    private lateinit var contextos : List<br.ufpb.dcx.apps4society.educapimanager.model.bean.Context>
    private lateinit var listview: ListView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getContextsFromService()
         val root = inflater.inflate(R.layout.fragment_nav_choose_context, container, false)

        listview = root.findViewById(R.id.listview_choose)

        listview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            CreateObjectFacade.instance.tempChallenge.contexts.add(ContextDTO(contextos[position]))
            contextos[position].challenges.add(CreateObjectFacade.instance.tempChallenge)
            updateContext(contextos[position])
            insertChallenge(CreateObjectFacade.instance.tempChallenge)
        }

        return root
    }

    fun getContextsFromService(){
        val call = RetrofitInitializer().contextService().findByUser(CreateObjectFacade.instance.tempSession.creator.id)
        call.enqueue(object : Callback<List<br.ufpb.dcx.apps4society.educapimanager.model.bean.Context>> {
            override fun onFailure(
                call: Call<List<br.ufpb.dcx.apps4society.educapimanager.model.bean.Context>>,
                t: Throwable
            ) {
                Toast.makeText(context,"Ocorreu um Erro"+t.message,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<br.ufpb.dcx.apps4society.educapimanager.model.bean.Context>>,
                response: Response<List<br.ufpb.dcx.apps4society.educapimanager.model.bean.Context>>
            ) {
                contextos = response.body()!!
                initializeSpinner(response.body()!!)
                Toast.makeText(context,"Lista recuperada com sucesso",Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun updateContext(c:br.ufpb.dcx.apps4society.educapimanager.model.bean.Context){
        val call = RetrofitInitializer().contextService().update(c,c.id)

        call.enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {

            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {

            }

        })
    }

    fun insertChallenge(c:br.ufpb.dcx.apps4society.educapimanager.model.bean.Challenge){
        val call = RetrofitInitializer().challengeService().insert(c)

        call.enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(context,"Desafio não cadastrado",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.isSuccessful){
                    Toast.makeText(context,"Desafio Cadastrado Com sucesso",Toast.LENGTH_LONG).show()
                    CreateObjectFacade.instance.clearTempChallenge()
                }
                else{
                    Toast.makeText(context,"Algo Deu Errado, Tente Novamente"+response.code(),Toast.LENGTH_LONG).show()
                }
            }

        })
    }

    fun initializeSpinner(contexts: List<br.ufpb.dcx.apps4society.educapimanager.model.bean.Context>){
        val names = arrayListOf<String>()
        for (c:br.ufpb.dcx.apps4society.educapimanager.model.bean.Context in contexts){
            names.add(c.name)
        }
        val adapter = context?.let { ArrayAdapter(it,R.layout.sample_text_view_list,R.id.text_view_list,names) }

        listview.adapter = adapter
    }




}
