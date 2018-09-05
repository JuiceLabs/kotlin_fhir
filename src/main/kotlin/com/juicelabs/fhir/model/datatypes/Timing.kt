package com.juicelabs.fhir.model.datatypes

import com.fasterxml.jackson.annotation.JsonProperty
import com.juicelabs.fhir.model.Base
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/datatypes.html#timing
 */
@Entity
open class Timing(
        @ElementCollection
        val event: Set<LocalDateTime>,

        val repeat: Repeat?,

        val code: CodeableConcept?
) : Base()


@Entity
data class Repeat(
        val bounds: Bounds?,

        val count: Int?,

        val countMax: Int?,

        val duration: Int?,

        val durationMax: Int?,

        val durationUnit: Int?,

        val frequency: Int?,

        val frequencyMax: Int?,

        val period: BigDecimal?,

        val periodMax: BigDecimal?,

        val periodUnit: String?, // todo code

        @ElementCollection
        val dayOfWeek: Set<String>, // todo code

        @ElementCollection
        val timeOfDay: Set<LocalDateTime>,

        @ElementCollection
        @JsonProperty("when")
        val when_: Set<String>, // todo code

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "offset_id")
        val offset: CodeableConcept?
) : Base()


data class Bounds(
        val boundsDuration: Quantity, // todo Duration,

        val boundsRange: Range,

        val BoundsPeriod: Period
): Base()