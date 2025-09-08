package at.mappie.mappietest.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.time.Instant

@Embeddable
data class EventMetadata(
    @Column(nullable = false, updatable = false)
    val eventTimestamp: Instant = Instant.now(),

    @Column(length = 20)
    val eventSource: String? = null,
)
