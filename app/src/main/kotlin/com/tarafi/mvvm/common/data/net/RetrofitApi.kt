package com.tarafi.mvvm.common.data.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by TARAFI Ahmed on 06/11/2021
 */
const val HOST_URL = "https://api.jcdecaux.com/vls/v1/"

object RetrofitApi {

    private var instance: Retrofit?

    init {
        instance = null
    }

    private fun initInstance() {
        if (instance != null) {
            return
        }

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClientBuilder = OkHttpClient.Builder().addInterceptor(logging)
        val okhttpClient = okHttpClientBuilder.build()

        instance = Retrofit.Builder().baseUrl(HOST_URL).client(okhttpClient).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        return
    }

    fun <Service> createService(_class: Class<Service>): Service {
        initInstance()
        val service: Service? = instance?.create(_class)
        return service!!
    }

}