package br.ufpb.dcx.apps4society.educapimanager.control.service

import br.ufpb.dcx.apps4society.educapimanager.model.Challenge
import retrofit2.Call
import retrofit2.http.GET

interface ChallengeService{
    fun find(id: Long?)

    fun insert()

    fun update()

    fun delete(id: Long?)

    @GET("challenges")
    fun findAll() : Call<List<Challenge>>

    fun findPage(
        page: Int?,
        linesPerPage: Int?,
        orderBy: String,
        direction: String
    )
}