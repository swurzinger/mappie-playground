package at.mappie.mappietest.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.math.BigDecimal

@Embeddable
data class WeightDetails(
    @Column(precision = 19, scale = 3)
    val grossWeight: BigDecimal,
    @Column(length = 3)
    val unitOfWeight: String,
)
