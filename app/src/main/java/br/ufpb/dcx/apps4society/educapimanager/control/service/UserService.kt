package br.ufpb.dcx.apps4society.educapimanager.control.service

import br.ufpb.dcx.apps4society.educapimanager.model.dto.UserDTO
import retrofit2.Call
import retrofit2.http.*

interface UserService{

    @GET("users")
    fun findAll() : Call <ArrayList<UserDTO>>

    @GET("users/{id}")
    fun findUser(@Path("id") id: Long) : Call<UserDTO>

    @POST("users")
    fun insert(@Body user : UserDTO) : Call<Void>

    @DELETE
    fun delete() : Call<Void>

    @PUT
    fun update () : Call<Void>



}