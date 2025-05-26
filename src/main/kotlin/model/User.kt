package dev.rmarcos.model

//import java.util.UUID
import kotlinx.serialization.Serializable

enum class Permission {
    COLABORATOR,
    MANAGER,
    ADMIN,
}

@Serializable
data class User (
    val uuid: String,
    val username: String,
    val email: String,
    val password: String,
    val permission: Permission,
    val profile: Profile
)