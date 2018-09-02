package com.juicelabs.fhir.model

import javax.persistence.*

/**
 * https://www.hl7.org/fhir/datatypes.html#CodeableConcept
 */

@Entity
data class CodeableConcept(
        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "codeable_concept_id")
        val coding: List<Coding>,

        val text: String? = null
): Base()