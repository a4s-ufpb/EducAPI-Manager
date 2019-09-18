package br.ufpb.dcx.apps4society.educapimanager.control.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private var BASE_URL : String = "https://educapi.herokuapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun contextService() = retrofit.create(ContextService::class.java)

}