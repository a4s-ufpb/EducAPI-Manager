package br.ufpb.dcx.apps4society.educapimanager.view.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.utils.SearchEngineClient
import com.google.api.services.customsearch.model.Result

class SearchFragment(fragment : Fragment, query : String)  : Fragment(), View.OnClickListener{
    private var query:String = query
    private lateinit var rv : RecyclerView
    private lateinit var laymanager : GridLayoutManager
    private lateinit var searchEngine : SearchEngineClient
    private var fragment:Fragment = fragment

    private  var  resultado :List<Result> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        super.onCreateView(inflater, container, savedInstanceState)
        val root = inflater.inflate(R.layout.fragment_nav_search,container,false)

        searchEngine = SearchEngineClient()
        rv = root.findViewById(R.id.search_rv)

        laymanager = GridLayoutManager(context,2,RecyclerView.VERTICAL,false)

        resultado = searchEngine.search(query)

        fillRecycleView(resultado)

        rv.adapter = this.context?.let { SearchListAdapter(resultado, it,this) }

        return root
    }

    fun fillRecycleView(resultado : List<Result>){
        rv.layoutManager = laymanager
        rv.adapter = context?.let { SearchListAdapter(resultado, it,this) }
    }

    override fun onClick(v: View?) {
        TODO("Ver o que da para botar aqui")
    }


}