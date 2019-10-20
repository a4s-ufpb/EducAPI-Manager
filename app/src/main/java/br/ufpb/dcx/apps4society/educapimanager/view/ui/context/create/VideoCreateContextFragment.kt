package br.ufpb.dcx.apps4society.educapimanager.view.ui.context.create

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.view.ui.url.UrlFragment

class VideoCreateContextFragment : Fragment(), View.OnClickListener {
    private var TAG : String = "VideoCreateContextFragment"
    private lateinit var btnVideoUrl : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_create_context_3_video, container, false)
        btnVideoUrl = root.findViewById(R.id.btnVideoUrl)
        btnVideoUrl.setOnClickListener(this)
        return root
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnVideoUrl -> {
                Log.i(TAG, "CLICOU BTN URL VIDEO")
                val transaction = fragmentManager?.beginTransaction()
                val urlFragment : UrlFragment = UrlFragment()
                urlFragment.type = UrlFragment.VIDEO_URL
                transaction?.replace(R.id.frameAuxVideoFragment, urlFragment)
                transaction?.addToBackStack(null)
                transaction?.commit()
            }
        }
    }
}