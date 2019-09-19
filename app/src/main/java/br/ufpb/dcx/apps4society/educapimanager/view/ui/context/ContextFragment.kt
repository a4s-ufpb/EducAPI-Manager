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
import br.ufpb.dcx.apps4society.educapimanager.model.Context
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

    fun fillRecycleView(contexts : List<Context>){
        recyclerView.layoutManager = layManager
        recyclerView.adapter = ContextListAdapter(contexts)
    }

    fun getAllContextsFromService(){
        val call = RetrofitInitializer().contextService().findAll()
        call.enqueue(object: Callback<List<Context>?> {
            override fun onResponse(call: Call<List<Context>?>?, response: Response<List<Context>?>?) {
                response?.body()?.let {
                    fillRecycleView(it)
                }
            }

            override fun onFailure(call: Call<List<Context>?>?, t: Throwable?) {
                Log.e(TAG, t?.message)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        getAllContextsFromService()
    }
}