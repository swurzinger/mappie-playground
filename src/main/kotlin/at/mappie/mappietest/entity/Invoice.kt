package at.mappie.mappietest.entity

import jakarta.persistence.*

@Entity
data class Invoice(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val invoiceId: Int = 0,

    @Column(length = 10)
    val invoiceNumber: String = "",

    @OneToMany(mappedBy = "invoice", cascade = [CascadeType.ALL], orphanRemoval = true)
    val items: MutableList<InvoiceLineItem> = mutableListOf(),

    @Embedded
    val eventMetadata: EventMetadata,
) {


}
