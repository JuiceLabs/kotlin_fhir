package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.Identifier
import com.juicelabs.fhir.model.datatypes.Period
import java.time.LocalDateTime
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/appointment.html
 */

@Entity
open class Appointment(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "identifier_id")
        val identifier: List<Identifier>,

        val status: String, // todo code

        val serviceCategory: CodeableConcept?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "service_type_id")
        val serviceType: Set<CodeableConcept>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "specialty_id")
        val specialty: Set<CodeableConcept>,

        val appointmentType: CodeableConcept?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "reason_id")
        val reason: Set<CodeableConcept>,

//        val indication todo ref

        val priority: Int?, // unsigned

        val description: String?,

//        val supportingInformation: Any todo ref

        val start: LocalDateTime?,

        val end: LocalDateTime?,

        var minutesDuration: Int?,

//        var slot: Slot todo ref

        var created: LocalDateTime?,

        var comment: String?,

//        var incomingReferral: ReferalRequest todo ref

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "participant_id")
        var participant: Set<Participant>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "requested_period_id")
        var requestedPeriod: Set<Period>


    )