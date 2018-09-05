package com.juicelabs.fhir.model.resource

import com.fasterxml.jackson.annotation.JsonProperty
import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.Coding
import com.juicelabs.fhir.model.datatypes.Identifier
import com.juicelabs.fhir.model.datatypes.Period
import com.juicelabs.fhir.model.subs.Location
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/encounter.html
 */
@Entity
open class Encounter(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "identifier_id")
        val identifier: List<Identifier>,

        val status: String, // todo code

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "status_history_id")
        val statusHistory: Set<StatusHistory>,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "connection_type_id")
        @JsonProperty("class")
        val class_: Coding,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "class_history_id")
        val classHistory: Set<ClassHistory>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "type_id")
        val type: Set<CodeableConcept>,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "priority_id")
        val priority: CodeableConcept?,

//        val subject todo ref
//        val episodeOfCare todo ref
//        val incomingreferral todo ref

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "participant_id")
        val participant: Set<Participant>,

//        var appointment todo ref

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "period_id")
        val period: Period?,

        val length: Long?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "reason_id")
        val reason: Set<CodeableConcept>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "diagnosis_id")
        val diagnosis: Set<Diagnosis>,

//        val account todo ref

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "hospitaliazion_id")
        val hospitialization: Hospitalization?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "location_id")
        val location: Set<Location>

//        val serviceProvider todo ref
//        val partOf todo ref
)


@Entity
data class Hospitalization(
        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "identifier_id")
        val preAdmissiondentifier: List<Identifier>,

//        val origin todo ref

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "admit_source_id")
        val admitSource: CodeableConcept?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "re_admission_id")
        val reAdmission: CodeableConcept?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "diet_preference_id")
        val dietPreference: Set<CodeableConcept>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "special_courtesy_id")
        val specialCourtesy: Set<CodeableConcept>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "special_arrangement_id")
        val specialArrangment: Set<CodeableConcept>,

//        val destination todo ref

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "discharge_disposition_id")
        val dischargeDisposition: CodeableConcept?

) : Base()

@Entity
data class Participant(
        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "type_id")
        val type: Set<CodeableConcept>,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "period_id")
        val period: Period?

//        val actor todo ref

//        val individual todo ref
) : Base()

@Entity
data class ClassHistory(
        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "class_id")
        @JsonProperty("class")
        val class_: Coding?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "period_id")
        val period: Period?
) : Base()