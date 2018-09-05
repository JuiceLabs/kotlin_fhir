package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.Identifier
import com.juicelabs.fhir.model.datatypes.Period
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/episodeofcare.html
 */
@Entity
open class EpisodeOfCare(
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

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "type_id")
        val type: Set<CodeableConcept>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "diagnosis_id")
        val diagnosis: Set<Diagnosis>,

//        val patient todo ref

//        val managingOrganization: todo ref

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "period_id")
        val period: Period?

//        val referralRequest todo ref
//        val careManager todo ref
//        val team todo ref
//        val account todo ref
)

@Entity
data class StatusHistory(
        val status: String, // todo code

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "period_id")
        val period: Period
) : Base()

@Entity
data class Diagnosis(
//        val condition todo ref
        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "role_id")
        val role: CodeableConcept?,

        val rank: Int?
) : Base()
