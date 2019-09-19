package br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.ufpb.dcx.apps4society.educapimanager.R

class NameCreateChallengeFragment : Fragment() {
    private var TAG : String = "NameCreateChallengeFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_create_context_1_name, container, false)
        return root
    }
}