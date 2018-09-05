package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.Identifier
import java.time.LocalDateTime
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/slot.html
 */
@Entity
open class Slot(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "identifier_id")
        val identifier: List<Identifier>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "service_category_id")
        val serviceCategory: Set<CodeableConcept>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "service_type_id")
        val serviceType: Set<CodeableConcept>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "specialty_id")
        val specialty: Set<CodeableConcept>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "appointment_type_id")
        val appointmentType: Set<CodeableConcept>,

//        val schedule todo ref

        val status: String, // todo code

        val start: LocalDateTime,

        val end: LocalDateTime,

        val overbooked: Boolean?,

        val comment: String?
)