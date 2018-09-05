package com.juicelabs.fhir.model.datatypes

import com.juicelabs.fhir.model.Base
import java.net.URI
import javax.persistence.Entity

/**
 * https://www.hl7.org/fhir/datatypes.html#Quantity
 */
@Entity
data class Quantity(
        val value: Int?, // todo right type?
        val comparator: String?, // todo code enum
        val unit: String?,
        val system: URI?,
        val code: String?
) : Base()
