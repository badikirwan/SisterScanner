package com.badikirwan.sistersacnner.sisterscanner.model

import com.google.gson.annotations.SerializedName

data class ExamCard(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: Boolean
)