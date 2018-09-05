package com.juicelabs.fhir.model.datatypes

import com.juicelabs.fhir.model.Base
import java.time.LocalDateTime
import javax.persistence.Entity

/**
 *  https://www.hl7.org/fhir/datatypes.html#Period
 */
@Entity
data class Period(
        val start: LocalDateTime,
        val end: LocalDateTime
): Base()