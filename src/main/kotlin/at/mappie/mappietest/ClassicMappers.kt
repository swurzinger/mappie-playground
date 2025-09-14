package at.mappie.mappietest

/*

import at.mappie.mappietest.entity.*
import at.mappie.mappietest.dto.EventMetadata as EventMetadataModel
import at.mappie.mappietest.dto.Invoice as InvoiceDto
import at.mappie.mappietest.dto.InvoiceLineItem as InvoiceLineItemDto
import at.mappie.mappietest.dto.WeightDetails as WeightDetailsDto

fun InvoiceDto.toEntity(eventMetadata: EventMetadataModel) =
    Invoice(
        invoiceNumber = this.invoiceNumber,
        items = mutableListOf(),
        eventMetadata = eventMetadata.toEntity(),
    ).also { invoice ->
        invoice.items.addAll(this.items?.map { it.toEntity(invoice) } ?: emptyList())
    }


fun InvoiceLineItemDto.toEntity(invoice: Invoice) = InvoiceLineItem(
    invoiceItemNumber = this.invoiceItemNumber,
    weightDetails = this.weightDetails?.toEntity(),
    invoice = invoice,
)

fun WeightDetailsDto.toEntity() =
    if (this.grossWeight != null && this.unitOfWeight != null)
        WeightDetails(grossWeight = this.grossWeight, unitOfWeight = this.unitOfWeight)
    else null

fun EventMetadataModel.toEntity() = EventMetadata(eventSource = this.eventSource, eventTimestamp = this.eventTimestamp)

*/
