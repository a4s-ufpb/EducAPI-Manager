package br.ufpb.dcx.apps4society.educapimanager.view.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Não disponivel nesta versão"
    }
    val text: LiveData<String> = _text
}