package br.ufpb.dcx.apps4society.educapimanager.view.ui.context.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.ufpb.dcx.apps4society.educapimanager.R

class PhotoCreateContextFragment : Fragment() {
    private var TAG : String = "PhotoCreateContextFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_create_context_2_photo, container, false)
        return root
    }
}