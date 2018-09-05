package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.datatypes.*
import java.net.URI
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/endpoint.html
 */
@Entity
open class Endpoint(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val identifier: List<Identifier>,

        val status: String, // todo code

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "connection_type_id")
        val connectionType: Coding,

        val name: String?,

//        val managingOrganization todo ref

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "contact_id")
        val contact: Set<ContactPoint>,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "period_id")
        val period: Period?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "payload_type_id")
        val payloadType: Set<CodeableConcept>,

        @ElementCollection
        val payloadMimeType: Set<String>, // todo code

        val address: URI,

        @ElementCollection
        val header: Set<String>
)