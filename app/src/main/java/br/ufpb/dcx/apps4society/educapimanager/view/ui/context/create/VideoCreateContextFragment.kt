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
import br.ufpb.dcx.apps4society.educapimanager.control.ButtonListener
import br.ufpb.dcx.apps4society.educapimanager.control.facade.CreateObjectFacade
import br.ufpb.dcx.apps4society.educapimanager.view.ui.url.UrlFragment

class VideoCreateContextFragment : Fragment(), View.OnClickListener, ButtonListener {

    private var TAG : String = "VideoCreateContextFragment"
    private lateinit var btnVideoUrl : Button
    private lateinit var btnVideoGalery : Button
    private lateinit var btnVideoRecord : Button
    private lateinit var tvVideoContextName : TextView
    private var buttons : java.util.ArrayList<Button> = java.util.ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_create_context_3_video, container, false)
        btnVideoUrl = root.findViewById(R.id.btnVideoUrl)
        btnVideoUrl.setOnClickListener(this)
        btnVideoGalery = root.findViewById(R.id.btnVideoGalery)
        btnVideoGalery.setOnClickListener(this)
        btnVideoRecord = root.findViewById(R.id.btnVideoRecord)
        btnVideoRecord.setOnClickListener(this)

        buttons.addAll(listOf(btnVideoUrl, btnVideoGalery, btnVideoRecord))

        tvVideoContextName = root.findViewById(R.id.tvVideoContextName)
        tvVideoContextName.text = "Vídeo do contexto " + CreateObjectFacade.instance.tempContext.name
        return root
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnVideoUrl -> {
                loadUrlFragment()
            }
        }
    }

    private fun loadUrlFragment(){
        val transaction = fragmentManager?.beginTransaction()
        val urlFragment : UrlFragment = UrlFragment(this)
        urlFragment.type = UrlFragment.VIDEO_URL
        transaction?.replace(R.id.frameAuxVideoFragment, urlFragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

    override fun getListeners(): List<Button> {
        return buttons
    }
}