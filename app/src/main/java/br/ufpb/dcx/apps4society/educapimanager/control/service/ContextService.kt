package br.ufpb.dcx.apps4society.educapimanager.control.service

import br.ufpb.dcx.apps4society.educapimanager.model.Context
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*


interface ContextService{

    fun find(id: Long?)

    @POST("contexts")
    fun insert(@Body context : Context) : Call<Void>

    fun update()

    fun delete(id: Long?)

    @GET("contexts")
    fun findAll() : Call<List<Context>>

    fun findPage(
        page: Int?,
        linesPerPage: Int?,
        orderBy: String,
        direction: String
    )
    
}