package br.ufpb.dcx.apps4society.educapimanager.view.ui.url

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.view.ui.context.create.PhotoCreateContextFragment
import br.ufpb.dcx.apps4society.educapimanager.view.ui.context.create.PhotoCreateContextFragment.OnResponseListener
import com.google.android.material.textfield.TextInputLayout

class UrlFragment : Fragment(), View.OnClickListener{

    private var TAG : String = "UrlFragment"
    private lateinit var confirmBtn : Button
    private lateinit var urlTextInput : TextInputLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.get_url_input_fragment, container, false)
        confirmBtn = root.findViewById(R.id.btnConfirmUrl)
        urlTextInput = root.findViewById(R.id.tilUrl)
        confirmBtn.setOnClickListener(this)
        return root
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnConfirmUrl -> {
                PhotoCreateContextFragment.confirmUrl(object : OnResponseListener {
                    override fun onClickConfirm(): String {
                        return urlTextInput.editText?.text.toString()
                    }
                })
            }
        }
    }
}