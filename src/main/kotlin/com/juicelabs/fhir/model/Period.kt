package com.juicelabs.fhir.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Period(
        val start: LocalDateTime,
        val end: LocalDateTime
): Base()