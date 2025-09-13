package at.mappie.mappietest

import at.mappie.mappietest.entity.EventMetadata
import at.mappie.mappietest.entity.Invoice
import at.mappie.mappietest.entity.InvoiceLineItem
import at.mappie.mappietest.entity.WeightDetails
import tech.mappie.api.ObjectMappie
import tech.mappie.api.ObjectMappie2
import java.math.BigDecimal
import at.mappie.mappietest.dto.EventMetadata as EventMetadataDto
import at.mappie.mappietest.dto.Invoice as InvoiceSapDto
import at.mappie.mappietest.dto.InvoiceLineItem as InvoiceLineItemDto
import at.mappie.mappietest.dto.WeightDetails as WeightDetailsDto

class Mappers {

    object WeightDetailsMapper : ObjectMappie<WeightDetailsDto, WeightDetails>() {
        override fun map(from: WeightDetailsDto): WeightDetails = mapping {
            to::grossWeight fromProperty from::grossWeight transform { it ?: BigDecimal.ZERO }
            to::unitOfWeight fromProperty from::unitOfWeight transform { it ?: "" }
        }
    }

    object EventMetadataMapper : ObjectMappie<EventMetadataDto, EventMetadata>()

    object InvoiceLineItemMapper : ObjectMappie2<InvoiceLineItemDto, Invoice, InvoiceLineItem>() {

        override fun map(first: InvoiceLineItemDto, second: Invoice): InvoiceLineItem = mapping {
            to::invoice fromValue second
        }

    }

    object InvoiceMapper : ObjectMappie2<InvoiceSapDto, EventMetadataDto, Invoice>() {
        override fun map(first: InvoiceSapDto, second: EventMetadataDto): Invoice = mapping {
            to::eventMetadata fromValue run { EventMetadataMapper.map(second) }
            to::items fromValue mutableListOf()
        }

//        fun mapActually(first: InvoiceSapDto, second: EventMetadataDto): Invoice = map(first, second)
//            .also { invoice ->
//                invoice.items.addAll(first.items?.map { InvoiceLineItemMapper.map(it, invoice) } ?: emptyList())
//            }
    }
}
