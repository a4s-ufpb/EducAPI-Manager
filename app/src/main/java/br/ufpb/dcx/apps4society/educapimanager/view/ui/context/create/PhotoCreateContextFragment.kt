package br.ufpb.dcx.apps4society.educapimanager.view.ui.context.create

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import br.ufpb.dcx.apps4society.educapimanager.R
import br.ufpb.dcx.apps4society.educapimanager.view.ui.context.CreateContextActivity
import br.ufpb.dcx.apps4society.educapimanager.view.ui.url.UrlFragment

class PhotoCreateContextFragment : Fragment(), View.OnClickListener {
    private var TAG : String = "PhotoCreateContextFragment"
    private lateinit var btnImageUrl : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_create_context_2_photo, container, false)
        btnImageUrl = root.findViewById(R.id.btnImageUrl)
        btnImageUrl.setOnClickListener(this)
        Log.i(TAG, btnImageUrl.text.toString())
        return root
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnImageUrl -> {
                val transaction = fragmentManager?.beginTransaction()
                val urlFragment : UrlFragment = UrlFragment()
                transaction?.replace(R.id.frameAuxFragment, urlFragment)
                transaction?.addToBackStack(null)
                transaction?.commit()

            }
        }
    }

    companion object {
        fun confirmUrl(hook : OnResponseListener){
            var url : String = hook.onClickConfirm()
            var bundleOf : Bundle = bundleOf("image_url" to url)
            CreateContextActivity.instance.nextFragment(bundleOf)
            Log.i("AGUA", url)
        }
    }

    interface OnResponseListener{
        fun onClickConfirm(): String
    }
}