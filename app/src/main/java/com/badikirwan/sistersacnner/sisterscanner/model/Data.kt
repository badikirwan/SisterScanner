package com.badikirwan.sistersacnner.sisterscanner.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("barcode_url")
    val barcodeUrl: String,
    @SerializedName("file_foto")
    val fileFoto: String,
    @SerializedName("jenis_kartu")
    val jenisKartu: String,
    @SerializedName("jenjang")
    val jenjang: String,
    @SerializedName("jurusan")
    val jurusan: String,
    @SerializedName("kaprodi")
    val kaprodi: Boolean,
    @SerializedName("kode_kartu")
    val kodeKartu: String,
    @SerializedName("mhs_nim")
    val mhsNim: String,
    @SerializedName("nama_lengkap")
    val namaLengkap: String,
    @SerializedName("semester")
    val semester: String,
    @SerializedName("status_mhs")
    val statusMhs: String,
    @SerializedName("tahun_ajaran")
    val tahunAjaran: String,
    @SerializedName("tahun_angkatan")
    val tahunAngkatan: String
)