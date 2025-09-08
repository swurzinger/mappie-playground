package at.mappie.mappietest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.Instant
import at.mappie.mappietest.dto.EventMetadata as EventMetadataDto
import at.mappie.mappietest.dto.Invoice as InvoiceDto
import at.mappie.mappietest.dto.InvoiceLineItem as InvoiceLineItemDto
import at.mappie.mappietest.dto.WeightDetails as WeightDetailsDto

class MappieMapperTest {

    @Test
    fun test() {

        val invoice = InvoiceDto(
            invoiceNumber = "123123",
            items = listOf(
                InvoiceLineItemDto(
                    invoiceItemNumber = "001",
                    weightDetails = WeightDetailsDto(
                        grossWeight = BigDecimal("123.234"),
                        unitOfWeight = "KG",
                    )
                )
            )
        )

        val result = Mappers.InvoiceMapper.mapActually(invoice, EventMetadataDto(Instant.now()))

        assertThat(result).isNotNull()
    }


}
