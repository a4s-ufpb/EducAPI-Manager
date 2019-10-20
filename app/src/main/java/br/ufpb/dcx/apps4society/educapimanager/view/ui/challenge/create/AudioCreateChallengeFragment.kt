package br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.control.facade.CreateObjectFacade

class AudioCreateChallengeFragment : Fragment() {
    private var TAG : String = "AudioCreateChallengeFragment"
    private lateinit var tvRecordAudioChallengeName : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_create_challenge_4_audio, container, false)
        tvRecordAudioChallengeName = root.findViewById(R.id.tvRecordAudioChallengeName)
        tvRecordAudioChallengeName.text = "Grave a pronúncia de " + CreateObjectFacade.instance.tempChallenge.word
        return root
    }
}