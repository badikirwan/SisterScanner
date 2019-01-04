package com.badikirwan.sistersacnner.sisterscanner.api

import com.badikirwan.sistersacnner.sisterscanner.model.ExamCard
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SisterService {

    @Headers("SISTER_API_KEY: 515959C5E9DC4767965215C84B78DE9C" )
    @GET("kartu_ujian/index")
    fun getDataMhs(@Query("kode_kartu") id: String?): Call<ExamCard>
}