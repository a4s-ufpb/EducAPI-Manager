package br.ufpb.dcx.apps4society.educapimanager.control.service

import br.ufpb.dcx.apps4society.educapimanager.model.bean.Context
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ContextDTO
import br.ufpb.dcx.apps4society.educapimanager.model.dto.ContextNewDTO
import retrofit2.Call
import retrofit2.http.*


interface ContextService{

    fun find(id: Long?)

    @POST("contexts")
    fun insert(@Body context : Context) : Call<Void>


    @PUT("contexts/{id}")
    fun update (@Body context : Context,@Path("id") id :Long,@Query("user") userid:Long ) : Call<Void>

    @DELETE("contexts/{id}")
    fun delete(@Path("id")idContext: Long,@Query("user")idUser:Long): Call<Void>




    @GET("contexts")
    fun findByUser(@Query("user") id:Long) : Call<List<Context>>

    @GET("contexts")
    fun findAll() : Call<List<ContextDTO>>

    @GET("contexts")
    fun findAllContexts() : Call<List<Context>>

    fun findPage(
        page: Int?,
        linesPerPage: Int?,
        orderBy: String,
        direction: String
    )
    
}