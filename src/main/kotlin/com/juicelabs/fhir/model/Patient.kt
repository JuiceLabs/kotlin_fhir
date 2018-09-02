package com.juicelabs.fhir.model

import java.io.Serializable
import java.time.LocalDate
import java.util.*
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/patient.html
 */

@Entity
data class Patient(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

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
        val gender: String,
        val birthDate: LocalDate,
        val deceasedBoolean: Boolean = false,
        val deceasedDateTime: LocalDate? = null,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val address: List<Address>?,

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "codeable_concept_id")
        val maritalStatus: CodeableConcept?,
        val multipleBirthBoolean: Boolean = false,
        val multipleBirthInteger: Int? = null,

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "attachment_id")
        val photo: Attachment?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
//        @OrderColumn
        val contact: List<Contact>?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val animal: List<Animal>?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val communication: List<Communication>?
//        val generalPractitioner: // todo
        // val managingOrganization: // todo
        // val link: // todd
) : Serializable


@Entity
data class Contact(
        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "contact_id")
        val relationship: List<CodeableConcept>?,

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "human_name_id")
        val name: HumanName?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "contact_id")
        val telecom: List<ContactPoint>,

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "address_id")
        val address: Address?,

        val gender: String?,

//        val organization: ref...  todo fix

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "period_id")
        val period: Period?
) : Base(), Serializable

@Entity
data class Animal(
        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "species_code_id")
        val species: CodeableConcept?,

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "breed_id")
        val breed: CodeableConcept?,

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "gender_status_id")
        val genderStatus: CodeableConcept?
) : Base(), Serializable

@Entity
data class Communication(
        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "code_id")
        val language: CodeableConcept,

        val preferred: Boolean
) : Base(), Serializable
