package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.Identifier
import com.juicelabs.fhir.model.datatypes.Timing
import java.time.LocalDateTime
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/devicemetric.html
 */

@Entity
open class DeviceMetric(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "identifier_id")
        val identifier: Identifier,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "type_id")
        val type: CodeableConcept,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "unit_id")
        val unit: CodeableConcept?,

//        val source todo ref
//        val parent todo ref

        val operationalStatus: String?, // todo code

        val color: String?, // todo code

        val category: String?, // todo code

        val measurementPeriod: Timing?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "calibration_id")
        val calibration: Set<Calibration>
)


@Entity
data class Calibration(
        val type: String?, // todo code

        val state: String?, // todo code

        val time: LocalDateTime?
): Base()