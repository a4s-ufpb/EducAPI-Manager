package br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge

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
import br.ufpb.dcx.apps4society.educapimanager.model.Challenge
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChallengeFragment : Fragment() {

    private lateinit var layManager : LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private var TAG : String = "CreateFragmentFragmentName"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_challenge, container, false)
        recyclerView = root.findViewById(R.id.challenge_recycle_view)
        layManager = LinearLayoutManager(context)
        return root
    }


    fun fillRecycleView(challenges : List<Challenge>){
        recyclerView.layoutManager = layManager
        recyclerView.adapter = ChallengeListAdapter(challenges)
    }

    fun getAllChallengesFromService(){
        val call = RetrofitInitializer().challengeService().findAll()
        call.enqueue(object: Callback<List<Challenge>?> {
            override fun onResponse(call: Call<List<Challenge>?>?, response: Response<List<Challenge>?>?) {
                response?.body()?.let {
                    fillRecycleView(it)
                }
            }

            override fun onFailure(call: Call<List<Challenge>?>?, t: Throwable?) {
                Log.e(TAG, t?.message)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        getAllChallengesFromService()
    }
}