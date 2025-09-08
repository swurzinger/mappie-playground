package at.mappie.mappietest.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.Valid
import jakarta.validation.constraints.Size


data class Invoice(

    @get:Size(min = 1, max = 10)
    @get:JsonProperty("invoiceNumber", required = true) val invoiceNumber: String,

    @field:Valid
    @get:Size(min = 1)
    @get:JsonProperty("items") val items: List<InvoiceLineItem>? = null,
)
