package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.ContactPoint
import com.juicelabs.fhir.model.datatypes.Identifier
import java.net.URI
import java.time.LocalDateTime
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/device.html
 */

@Entity
open class Device(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "identifier_id")
        val identifier: List<Identifier>,

        val udi: Udi?,

        val status: String?, // todo code

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "codeable_concept_id")
        val type: CodeableConcept?,

        val lotNumber: String?,

        val manufacturer: String?,

        val manufactureDate: LocalDateTime?,

        val expirationDate: LocalDateTime?,

        val model: String?,

        val version: String?,

//        val patient todo ref
//        val owner todo ref?

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "contact_id")
        val contact: Set<ContactPoint>?,

//        val location todo ref

        val uri: URI?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "note_id")
        val note: Set<com.juicelabs.fhir.model.datatypes.Annotation>?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "safety_id")
        val safety: Set<CodeableConcept>?
        )


@Entity
data class Udi(
        val deviceIdentifier: String?,

        val name: String?,

        val jurisdiction: URI?,

        val carrierHRF: String?,

        val carrierAIDC: String?, // base64Binary

        val issuer: URI?,

        val entryType: String? // todo code
): Base()