package br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.ufpb.dcx.apps4society.educapimanager.R

class PhotoCreateChallengeFragment : Fragment(){

    private var TAG : String = "PhotoCreateChallengeFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_create_challenge_2_photo, container, false)
        return root
    }

}