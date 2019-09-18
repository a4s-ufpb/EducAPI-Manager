package br.ufpb.dcx.apps4society.educapimanager.control.service

import br.ufpb.dcx.apps4society.educapimanager.model.Context
import retrofit2.Call
import retrofit2.http.GET


interface ContextService{

    fun find(id: Long?)

    fun insert()

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