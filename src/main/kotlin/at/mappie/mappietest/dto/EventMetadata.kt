package at.mappie.mappietest.dto

import java.time.Instant

data class EventMetadata(
    val eventTimestamp: Instant,
    val eventSource: String? = null,
)
