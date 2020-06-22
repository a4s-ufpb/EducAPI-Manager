package br.ufpb.dcx.apps4society.educapimanager.control.service

import br.ufpb.dcx.apps4society.educapimanager.model.bean.Challenge
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ChallengeDTO
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ChallengeNewDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ChallengeService{

    fun find(id: Long?)

    @POST("challenges")
    fun insert(@Body challenge : Challenge) : Call<Void>

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