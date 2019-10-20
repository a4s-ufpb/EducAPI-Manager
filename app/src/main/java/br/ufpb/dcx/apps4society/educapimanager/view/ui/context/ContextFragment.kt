package br.ufpb.dcx.apps4society.educapimanager.view.ui.context

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.control.service.RetrofitInitializer
import br.ufpb.dcx.apps4society.educapimanager.model.bean.Context
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ContextDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContextFragment : Fragment() {

    private lateinit var layManager : LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private var TAG : String = "CreateContextFragmentName"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_context, container, false)

        recyclerView = root.findViewById(R.id.context_recycle_view)
        layManager = LinearLayoutManager(context)

        return root
    }

    fun fillRecycleView(contexts : List<ContextDTO>){
        recyclerView.layoutManager = layManager
        recyclerView.adapter = context?.let { ContextListAdapter(contexts, it) }
    }

    fun getAllContextsFromService(){
        val call = RetrofitInitializer().contextService().findAll()
        call.enqueue(object: Callback<List<ContextDTO>?> {
            override fun onResponse(call: Call<List<ContextDTO>?>?, response: Response<List<ContextDTO>?>?) {
                response?.body()?.let {
                    fillRecycleView(it)
                }
            }

            override fun onFailure(call: Call<List<ContextDTO>?>?, t: Throwable?) {
                Log.e(TAG, t?.message)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        getAllContextsFromService()
    }
}