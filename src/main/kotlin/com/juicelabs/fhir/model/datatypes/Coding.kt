package com.juicelabs.fhir.model.datatypes

import com.juicelabs.fhir.model.Base
import java.net.URI
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/datatypes.html#Coding
 */

@Entity
data class Coding(
        val system: URI? = null,
        val version: String? = null,
        val code:String? = null,
        val display: String? = null,
        val userSelected: Boolean?
) : Base()


