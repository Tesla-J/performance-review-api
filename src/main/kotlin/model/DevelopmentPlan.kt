package dev.rmarcos.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class DevelopmentPlan (
    val id: Long,
    // val manager: Profile - does not make sense here
    @Contextual val startDate: LocalDate,
    @Contextual val endDate: LocalDate,
    val department: Department,
)