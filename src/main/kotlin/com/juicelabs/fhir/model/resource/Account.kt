package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.Identifier
import com.juicelabs.fhir.model.datatypes.Period
import com.juicelabs.fhir.model.datatypes.Quantity
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/account.html
 */

@Entity
open class Account(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "identifier_id")
        val identifier: List<Identifier>,

        val status: String?, // todo code

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "codeable_concept_id")
        val type: CodeableConcept?,

        val name: String?,

//        val subject todo ref

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "period_id")
        val period: Period?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "active_id")
        val active: Period?,

        val balance: Quantity?, // todo Money?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "coverage_id")
        val coverage: Set<CoveragePriority>,

//        val owner: Organization? // todo ref

        val description: String?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "guarantor_id")
        val guarantor: Set<Guarantor>
)


@Entity
data class CoveragePriority(
//        val coverage: Coverage, // todo ref

        val priority: Int? //positiveInt
): Base()

@Entity
data class Guarantor(
//        val party todo ref

        val onHold: Boolean?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "period_id")
        val period: Period?
): Base()
