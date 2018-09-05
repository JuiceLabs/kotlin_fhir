package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.datatypes.Attachment
import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.ContactPoint
import com.juicelabs.fhir.model.datatypes.Identifier
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/healthcareservice.html
 */
@Entity
open class HealthcareService(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val identifier: Set<Identifier>,

        val active: Boolean = false,

//        val providedBy todo ref

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "category_id")
        val category: CodeableConcept?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "type_id")
        val type: Set<CodeableConcept>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "specialty_id")
        val specialty: Set<CodeableConcept>,

//        val location todo ref

        val name: String?,

        val comment: String?,

        val extraDetails: String?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "photo_id")
        val photo: Attachment?,


        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val telecom: Set<ContactPoint>?,

//        val coverageArea todo ref

        @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        @JoinColumn(name = "service_provision_code_id")
        val serviceProvisionCode: Set<CodeableConcept>,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "eligibility_id")
        val eligibility: CodeableConcept?,

        val eligibilityNote:String?,

        @ElementCollection
        val programName: Set<String>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "characteristic_id")
        val characteristic: Set<CodeableConcept>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "eligibility_id")
        val referralMethod: Set<CodeableConcept>,

        val appointmentRequired: Boolean?,


        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "available_time_id")
        val availableTime: AvailableTime,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "not_available_id")
        val notAvailable: NotAvailable

//        val endpoint todo ref

)
