package br.ufpb.dcx.apps4society.educapimanager.view.ui.url

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.control.facade.CreateObjectFacade
import com.google.android.material.textfield.TextInputLayout

class UrlFragment : Fragment(), View.OnClickListener{

    private var TAG : String = "UrlFragment"
    private lateinit var confirmBtn : Button
    private lateinit var urlTextInput : TextInputLayout
    lateinit var type : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.get_url_input_fragment, container, false)
        confirmBtn = root.findViewById(R.id.btnConfirmUrl)
        urlTextInput = root.findViewById(R.id.tilUrl)
        urlTextInput.editText?.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.i(TAG, "TA ESCREVENDO A URL")
                Log.i(TAG, type)
                when(type){
                    IMAGE_URL -> {
                        CreateObjectFacade.instance.tempContext.imageUrl = urlTextInput.editText?.text.toString()
                        Log.i(TAG, CreateObjectFacade.instance.tempContext.imageUrl)
                    }

                    VIDEO_URL -> {
                        CreateObjectFacade.instance.tempContext.videoUrl = urlTextInput.editText?.text.toString()
                        Log.i(TAG, CreateObjectFacade.instance.tempContext.videoUrl)
                    }
                }
            }

        })
        confirmBtn.setOnClickListener(this)
        return root
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnConfirmUrl -> {
                fragmentManager?.popBackStack()
            }
        }
    }

    companion object{
        var IMAGE_URL = "image"
        var VIDEO_URL = "video"
    }
}