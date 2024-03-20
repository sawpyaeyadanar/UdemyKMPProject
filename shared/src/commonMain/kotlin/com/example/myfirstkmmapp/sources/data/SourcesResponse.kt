package com.example.myfirstkmmapp.sources.data

import com.example.myfirstkmmapp.sources.data.SourcesRaw
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourcesResponse (
    @SerialName("status") val status: String,
    @SerialName("sources") val sources: List<SourcesRaw>
)
