package dev.rmarcos.model

import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Assessment (
    val id: Long,
    val developmentPlan: DevelopmentPlan,
    val score: Int,
    val date: LocalDate,
    val minimalSuccessScore: Int,
)