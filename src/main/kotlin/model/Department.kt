package dev.rmarcos.model

import kotlinx.serialization.Serializable

@Serializable
data class Department (
    val id: Long,
    val name: String,
    val description: String,
    // val manager: Profile
    // manager attribute makes no sense here,
    // I predict an infinite chain on serialization
    // and a circular reference
)