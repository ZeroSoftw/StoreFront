package com.mx.farmaluxa.sharedutil.core.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SUService {

    @GET("{url}")
    suspend fun getServiceCoroutine(
        @Path(value = "url", encoded = true) url: String
    ): Response<Any>

    @POST("{url}")
    suspend fun postServiceCoroutine(
        @Path(value = "url", encoded = true) url: String,
        @Body entity: Any
    ): Response<Any>

}