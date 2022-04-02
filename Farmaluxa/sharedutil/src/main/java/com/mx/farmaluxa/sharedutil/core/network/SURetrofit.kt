package com.mx.farmaluxa.sharedutil.core.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object SURetrofit {

    /*private val authInterceptor = Interceptor { chain ->
        val url = chain.request()
            .url
            .newBuilder()
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .addHeader("Device-Id", preference.uuid)
            .url(url)
            .build()

        chain.proceed(newRequest)
    }*/

    private val interceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val client =
        OkHttpClient.Builder()
            .addNetworkInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
//            .addInterceptor(authInterceptor)
            .build()

    fun retrofitHelper(url: String? = null): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url ?: "" )
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}