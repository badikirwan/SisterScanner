package com.badikirwan.sistersacnner.sisterscanner.api

import com.badikirwan.sistersacnner.sisterscanner.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SisterRepository {

    fun create(): SisterService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()

        return retrofit.create(SisterService::class.java)
    }
}