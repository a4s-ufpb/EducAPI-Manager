package br.ufpb.dcx.apps4society.educapimanager.view.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.ufpb.dcx.apps4society.educapimanager.R

class AboutFragment : Fragment() {

    private lateinit var aboutViewModel: AboutViewModel
    private lateinit var text:TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        aboutViewModel =
            ViewModelProviders.of(this).get(AboutViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_about, container, false)
         text = root.findViewById(R.id.text_home)
        aboutViewModel.text.observe(this, Observer {
            text.text = it
        })
        return root
    }
}