package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.Identifier
import com.juicelabs.fhir.model.datatypes.Period
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/flag.html
 */

@Entity
open class Flag(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "identifier_id")
        val identifier: List<Identifier>,

        val status: String, // todo code

        val category: CodeableConcept?,

        val code: CodeableConcept,

//        val subject todo ref

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "period_id")
        val period: Period?

//        val encounter todo ref
//        val author todo ref
        )