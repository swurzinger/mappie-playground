package at.mappie.mappietest

import at.mappie.mappietest.entity.*
import tech.mappie.api.ObjectMappie
import tech.mappie.api.ObjectMappie2
import java.math.BigDecimal
import at.mappie.mappietest.dto.EventMetadata as EventMetadataDto
import at.mappie.mappietest.dto.Invoice as InvoiceDto
import at.mappie.mappietest.dto.InvoiceLineItem as InvoiceLineItemDto
import at.mappie.mappietest.dto.WeightDetails as WeightDetailsDto


fun InvoiceDto.toEntity(eventMetadata: EventMetadataDto) =
    MappieMappers.InvoiceMapper.mapWithItems(this, eventMetadata)

fun InvoiceLineItemDto.toEntity(invoice: Invoice) =
    MappieMappers.InvoiceLineItemMapper.map(this, invoice)

fun WeightDetailsDto.toEntity() =
    MappieMappers.WeightDetailsMapper.mapIfNotEmpty(this)

fun EventMetadataDto.toEntity() =
    MappieMappers.EventMetadataMapper.map(this)


private class MappieMappers {

    object WeightDetailsMapper : ObjectMappie<WeightDetailsDto, WeightDetails>() {
        override fun map(from: WeightDetailsDto): WeightDetails = mapping {
            to::grossWeight fromProperty from::grossWeight transform { it ?: BigDecimal.ZERO }
            to::unitOfWeight fromProperty from::unitOfWeight transform { it ?: "" }
        }

        fun mapIfNotEmpty(from: WeightDetailsDto): WeightDetails? =
            if (from.grossWeight != null && from.unitOfWeight != null) map(from) else null
    }

    object EventMetadataMapper : ObjectMappie<EventMetadataDto, EventMetadata>()

    object InvoiceLineItemMapper : ObjectMappie2<InvoiceLineItemDto, Invoice, InvoiceLineItem>() {

        override fun map(first: InvoiceLineItemDto, second: Invoice): InvoiceLineItem = mapping {
            to::invoice fromValue second
            to::weightDetails fromProperty first::weightDetails transform { it?.toEntity() }
        }

    }

    object InvoiceMapper : ObjectMappie2<InvoiceDto, EventMetadataDto, Invoice>() {
        override fun map(first: InvoiceDto, second: EventMetadataDto): Invoice = mapping {
            to::eventMetadata fromValue kotlin.run { second.toEntity() }
            to::items fromValue mutableListOf()
        }

        fun mapWithItems(first: InvoiceDto, second: EventMetadataDto): Invoice = map(first, second)
            .also { invoice ->
                invoice.items.addAll(first.items?.map { it.toEntity(invoice) } ?: emptyList())
            }
    }
}
