package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.datatypes.Address
import com.juicelabs.fhir.model.datatypes.ContactPoint
import com.juicelabs.fhir.model.datatypes.Identifier
import com.juicelabs.fhir.model.subs.Contact
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/organization.html
 */
@Entity
open class Organization(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val identifier: List<Identifier>,

        val active: Boolean = false,

        @ElementCollection
        val type: List<String>,

        val name: String?,

        @ElementCollection
        val alias: List<String>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val telecom: List<ContactPoint>?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val address: List<Address>?,

//        val partOf todo ref

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "contact_id")
        val contact: List<Contact>

//        val endpoint todo ref
)