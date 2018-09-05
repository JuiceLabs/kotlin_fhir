package com.juicelabs.fhir.model.datatypes

import com.fasterxml.jackson.annotation.JsonProperty
import com.juicelabs.fhir.model.Base
import java.net.URI
import java.time.LocalDateTime
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/datatypes.html#signature
 */
@Entity
open class Signature(
        @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "type_id")
        val type: Set<Coding>,

        @JsonProperty("when")
        val when_: LocalDateTime,

        val who: Who,

        val onBehalfOf: OnBehalfOf?,

        val contentType: String?, // todo code

        val blob: String // type: base64Binary

): Base()


@Entity
data class Who(
        val whoUri: URI

//        val whoReference // todo ref
): Base()


@Entity
data class OnBehalfOf(
        val onBehalfOf: URI
//        val onBehalfOfReference // todo ref
): Base()