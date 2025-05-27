package dev.rmarcos.model

import kotlinx.serialization.Serializable

@Serializable
data class Profile (
    val id: Long,
    val name: String,
    val phone: String,
    val altPhone: String,
    val role: String, // TODO find a better approach
    val department: Department
)