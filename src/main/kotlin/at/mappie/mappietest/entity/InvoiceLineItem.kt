package at.mappie.mappietest.entity

import jakarta.persistence.*

@Entity
data class InvoiceLineItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val invoiceLineItemId: Int = 0,

    @Column(length = 6)
    val invoiceItemNumber: String,


    @Embedded
    val weightDetails: WeightDetails? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invoice_id", nullable = false)
    var invoice: Invoice,
) {
    override fun toString(): String {
        return "InvoiceLineItem $invoiceItemNumber"
    }
}
