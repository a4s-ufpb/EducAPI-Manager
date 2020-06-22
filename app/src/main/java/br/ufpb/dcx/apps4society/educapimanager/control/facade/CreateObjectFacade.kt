package br.ufpb.dcx.apps4society.educapimanager.control.facade

import br.ufpb.dcx.apps4society.educapimanager.model.bean.Challenge
import br.ufpb.dcx.apps4society.educapimanager.model.bean.Context
import br.ufpb.dcx.apps4society.educapimanager.model.bean.Session
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ChallengeDTO
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ChallengeNewDTO
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ContextNewDTO

class CreateObjectFacade {
    companion object{
        val instance = CreateObjectFacade()
    }

    var tempContext : Context = Context()
    var tempChallenge : Challenge = Challenge()
    var tempSession : Session = Session()

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
    }

    fun clearTempSession(){
        tempSession.creator = null
    }


}