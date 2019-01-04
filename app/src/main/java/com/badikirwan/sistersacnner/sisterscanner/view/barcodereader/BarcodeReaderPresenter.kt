package com.badikirwan.sistersacnner.sisterscanner.view.barcodereader

import android.util.Log
import com.badikirwan.sistersacnner.sisterscanner.api.SisterRepository
import com.badikirwan.sistersacnner.sisterscanner.model.ExamCard
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BarcodeReaderPresenter(private val view: BarcodeReaderView) {

    fun getDataMahasiswa(id: String) {
        val sisterService = SisterRepository.create()
        sisterService.getDataMhs(id).enqueue(object : Callback<ExamCard> {
            override fun onFailure(call: Call<ExamCard>, t: Throwable) {
                Log.e("Errornya:", "${t.message}")
            }

            override fun onResponse(call: Call<ExamCard>, response: Response<ExamCard>) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    view.showDataMahasiswa(data!!)
                }
            }
        })

    }
}