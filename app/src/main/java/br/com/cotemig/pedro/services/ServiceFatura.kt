package br.com.cotemig.pedro.services

import br.com.cotemig.pedro.models.Fatura
import retrofit2.Call
import retrofit2.http.GET

interface ServiceFatura {

    @GET("fatura")
    fun getFatura(): Call<Fatura>

}