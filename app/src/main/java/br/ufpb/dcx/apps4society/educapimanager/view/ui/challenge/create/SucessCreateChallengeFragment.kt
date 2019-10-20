package br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.control.facade.CreateObjectFacade
import br.ufpb.dcx.apps4society.educapimanager.control.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SucessCreateChallengeFragment : Fragment() {
    private var TAG : String = "SucessCreateChallengeFragment"
    private lateinit var tvSucess : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_challenge_create_sucess, container, false)
        tvSucess = root.findViewById(R.id.tvStatusChallengeCreation)
        tvSucess.text = "Desafio '" + CreateObjectFacade.instance.tempChallenge.word + "' criado."
        saveChallenge()
        return root
    }

    private fun saveChallenge(){
        val call : Call<Void> = RetrofitInitializer().challengeService().insert(CreateObjectFacade.instance.tempChallenge)

        call.enqueue(object: Callback<Void?> {
            override fun onResponse(call: Call<Void?>?, response: Response<Void?>?) {
                if(response?.isSuccessful!!){
                    Toast.makeText(context, "Desafio criado com sucesso!", Toast.LENGTH_SHORT).show()
                    CreateObjectFacade.instance.clearTempChallenge()
                } else {
                    Toast.makeText(context, "Erro ao criar Desafio!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void?>?, t: Throwable?) {
                Toast.makeText(context, "Erro ao se comunicar com o serviço!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}