package br.ufpb.dcx.apps4society.educapimanager.control.service

import br.ufpb.dcx.apps4society.educapimanager.model.bean.Context
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ContextDTO
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ContextNewDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ContextService{

    fun find(id: Long?)

    @POST("contexts")
    fun insert(@Body context : ContextNewDTO) : Call<Void>

    fun update()

    fun delete(id: Long?)

    @GET("contexts")
    fun findAll() : Call<List<ContextDTO>>

    fun findPage(
        page: Int?,
        linesPerPage: Int?,
        orderBy: String,
        direction: String
    )
    
}