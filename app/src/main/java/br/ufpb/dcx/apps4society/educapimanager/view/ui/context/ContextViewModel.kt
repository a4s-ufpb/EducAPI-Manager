package br.ufpb.dcx.apps4society.educapimanager.view.ui.context

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContextViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Context Fragment"
    }
    val text: LiveData<String> = _text
}