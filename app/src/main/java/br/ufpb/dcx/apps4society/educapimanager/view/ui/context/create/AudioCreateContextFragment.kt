package br.ufpb.dcx.apps4society.educapimanager.view.ui.context.create

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.control.facade.CreateObjectFacade

class AudioCreateContextFragment : Fragment() {

    private var TAG : String = "AudioCreateContextFragment"
    private lateinit var tvRecordAudioContextName : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_create_context_4_audio, container, false)
        tvRecordAudioContextName = root.findViewById(R.id.tvRecordAudioContextName)
        tvRecordAudioContextName.text = "Grave a pronúncia de " + CreateObjectFacade.instance.tempContext.name
        return root
    }

}