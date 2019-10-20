package br.ufpb.dcx.apps4society.educapimanager.control.facade

import br.ufpb.dcx.apps4society.educapimanager.model.Challenge
import br.ufpb.dcx.apps4society.educapimanager.model.Context

class CreateObjectFacade {
    companion object{
        val instance = CreateObjectFacade()
    }

    var tempContext : Context = Context()
        get() = field
        set(value) {
            field = value
        }
    var tempChallenge : Challenge = Challenge()
        get() = field
        set(value) {
            field = value
        }


}