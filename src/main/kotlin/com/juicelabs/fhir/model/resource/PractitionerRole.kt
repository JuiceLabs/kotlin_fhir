package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.ContactPoint
import com.juicelabs.fhir.model.datatypes.Identifier
import com.juicelabs.fhir.model.datatypes.Period
import java.time.LocalDateTime
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/practitionerrole.html
 */
@Entity
open class PractitionerRole(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val identifier: List<Identifier>,

        val active: Boolean = false,

        // val practitioner todo ref
        // val organization todo ref
        @ElementCollection
        val code: List<String>,

        @ElementCollection
        val specialty: List<String>, // preferred ?
        // val location todo ref
        // val healthcareService todo ref

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val telecom: List<ContactPoint>?,


        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "available_time_id")
        val availableTime: List<AvailableTime>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "not_available_id")
        val notAvailable: List<NotAvailable>,

        val availabilityExceptions: String?

//        val endpoint todo ref
)

@Entity
data class AvailableTime(

        @ElementCollection
        val daysOfWeek: List<String>, // todo code

        val allDay: Boolean?,

        val availableStartTime: LocalDateTime?,

        val availableEndTime: LocalDateTime?
) : Base()

@Entity
data class NotAvailable(
        val description: String,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "during_id")
        val during: List<Period>
): Base()


