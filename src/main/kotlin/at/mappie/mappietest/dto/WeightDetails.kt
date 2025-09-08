package at.mappie.mappietest.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal


data class WeightDetails(

    @get:JsonProperty("grossWeight") val grossWeight: BigDecimal? = null,

    @get:JsonProperty("unitOfWeight") val unitOfWeight: String? = null
    ) {

}

