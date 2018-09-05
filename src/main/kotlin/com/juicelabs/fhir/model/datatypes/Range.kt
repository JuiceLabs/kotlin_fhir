package com.juicelabs.fhir.model.datatypes

import com.juicelabs.fhir.model.Base
import javax.persistence.Entity

/**
 * https://www.hl7.org/fhir/datatypes.html#Range
 */
@Entity
data class Range(
    val low: String?, // todo SimpleQuantity?,
    val high: String? // SimpleQuantity?
): Base()