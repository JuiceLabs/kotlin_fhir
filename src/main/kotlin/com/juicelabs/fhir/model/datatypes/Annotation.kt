package com.juicelabs.fhir.model.datatypes

import com.juicelabs.fhir.model.Base
import java.time.LocalDateTime
import javax.persistence.Entity

/**
 * https://www.hl7.org/fhir/datatypes.html#annotation
 */
@Entity
open class Annotation(
       val author: Author?,

       val time: LocalDateTime?,

       val text: String
): Base()

@Entity
data class Author(
//        val authorReference todo ref

    val authorString: String
): Base()