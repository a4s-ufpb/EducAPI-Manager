package br.ufpb.dcx.apps4society.educapimanager.control.facade

import br.ufpb.dcx.apps4society.educapimanager.model.Challenge
import br.ufpb.dcx.apps4society.educapimanager.model.Context

class CreateObjectFacade {
    companion object{
        val instance = CreateObjectFacade()
    }

    var tempContext : Context = Context()
    var tempChallenge : Challenge = Challenge()

    fun clearTempContext(){
        tempContext.id = -1
        tempContext.name = null
        tempContext.imageUrl = null
        tempContext.videoUrl = null
        tempContext.soundUrl = null
        tempContext.creator = null
        tempContext.challenges = HashSet<Challenge>()
    }

    fun clearTempChallenge(){
        tempChallenge.id = -1
        tempChallenge.word = null
        tempChallenge.imageUrl = null
        tempChallenge.videoUrl = null
        tempChallenge.soundUrl = null
        tempChallenge.creator = null
        tempChallenge.contexts = HashSet<Context>()
    }


}