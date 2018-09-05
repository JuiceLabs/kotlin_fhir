package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.*
import java.time.LocalDate
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/practitioner.html
 */
@Entity
open class Practitioner(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val identifier: List<Identifier>,

        val active: Boolean = false,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val name: List<HumanName>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val telecom: List<ContactPoint>?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val address: List<Address>?,

        val gender: String, // todo code

        val birthDate: LocalDate,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "attachment_id")
        val photo: Attachment?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "qualification_id")
        val qualification: List<Qualification>,

        @ElementCollection
        val communication: List<String>
)

@Entity
data class Qualification(
        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val identifier: List<Identifier>,

        val code: String?,

        val period: Period?
        // val issuer todo ref
) : Base()


