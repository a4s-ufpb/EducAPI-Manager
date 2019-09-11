package br.ufpb.dcx.apps4society.educapimanager.view.ui.challenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.ufpb.dcx.apps4society.educapimanager.R

class ChallengeFragment : Fragment() {

    private lateinit var challengeViewModel: ChallengeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        challengeViewModel =
            ViewModelProviders.of(this).get(ChallengeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_challenge, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        challengeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}