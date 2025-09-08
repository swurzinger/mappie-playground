package at.mappie.mappietest.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.Valid
import jakarta.validation.constraints.Size


data class InvoiceLineItem(

    @get:Size(min = 1, max = 6)
    @get:JsonProperty("invoiceItemNumber", required = true) val invoiceItemNumber: String,

    @field:Valid
    @get:JsonProperty("weightDetails") val weightDetails: WeightDetails? = null,
)
