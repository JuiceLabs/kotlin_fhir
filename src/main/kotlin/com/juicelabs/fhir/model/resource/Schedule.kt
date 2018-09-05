package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.Identifier
import com.juicelabs.fhir.model.datatypes.Period
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/schedule.html
 */
@Entity
open class Schedule(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "identifier_id")
        val identifier: List<Identifier>,

        val active: Boolean = false,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "service_category_id")
        val serviceCategory: Set<CodeableConcept>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "service_type_id")
        val serviceType: Set<CodeableConcept>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "specialty_id")
        val specialty: Set<CodeableConcept>,

//        val actor todo ref

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val planningHorizon: Set<Period>,

        val comment: String?
)