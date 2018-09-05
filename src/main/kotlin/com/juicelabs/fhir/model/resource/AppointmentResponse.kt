package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.Identifier
import java.time.LocalDateTime
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/appointmentresponse.html
 */

@Entity
open class AppointmentResponse(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "identifier_id")
        val identifier: List<Identifier>,

//        val appointment: Appointment todo ref

        val start: LocalDateTime?,

        val end: LocalDateTime?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "participant_type_id")
        val participantType: Set<CodeableConcept>,

//        val actor todo ref

        val participantStatus: String, // todo code

        val comment: String?

)