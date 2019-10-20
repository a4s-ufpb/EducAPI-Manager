package br.ufpb.dcx.apps4society.educapimanager.control.facade

import br.ufpb.dcx.apps4society.educapimanager.model.bean.Challenge
import br.ufpb.dcx.apps4society.educapimanager.model.bean.Context
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ChallengeNewDTO
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ContextNewDTO

class CreateObjectFacade {
    companion object{
        val instance = CreateObjectFacade()
    }

    var tempContext : ContextNewDTO = ContextNewDTO()
    var tempChallenge : ChallengeNewDTO = ChallengeNewDTO()

    fun clearTempContext(){
        tempContext.id = -1
        tempContext.name = null
        tempContext.imageUrl = null
        tempContext.videoUrl = null
        tempContext.soundUrl = null
        tempContext.userId = null
    }

    fun clearTempChallenge(){
        tempChallenge.id = -1
        tempChallenge.word = null
        tempChallenge.imageUrl = null
        tempChallenge.videoUrl = null
        tempChallenge.soundUrl = null
        tempChallenge.userId = -1
    }


}