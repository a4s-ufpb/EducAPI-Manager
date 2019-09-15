package br.ufpb.dcx.apps4society.educapimanager.view.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Context Fragment"
    }
    val text: LiveData<String> = _text
}