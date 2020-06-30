package br.ufpb.dcx.apps4society.educapimanager.control.service

import br.ufpb.dcx.apps4society.educapimanager.model.bean.Challenge
import br.ufpb.dcx.apps4society.educapimanager.model.bean.Context
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ChallengeDTO
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ChallengeNewDTO
import retrofit2.Call
import retrofit2.http.*

interface ChallengeService{

    fun find(id: Long?)

    @POST("challenges")
    fun insert(@Body challenge : Challenge) : Call<Void>

    @PUT("challenges/{id}")
    fun update (@Body challenge : Challenge, @Path("id") id :Long ) : Call<Void>

    @DELETE("challenges/{id}")
    fun delete(@Path("id")id: Long) : Call<Void>

    @GET("challenges")
    fun findByUser(@Query("user")id:Long):Call<List<Challenge>>

    @GET("challenges")
    fun findAll() : Call<List<Challenge>>

    fun findPage(
        page: Int?,
        linesPerPage: Int?,
        orderBy: String,
        direction: String
    )
}