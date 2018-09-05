package com.juicelabs.fhir.model.datatypes

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.Coding
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

//
//@MappedSuperclass
//data class CodeableConcept2(
//        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
//        @JoinColumn(name = "codeable_concept_id")
//        val coding: List<Coding2>,
//
//        val text: String? = null
//): Base()
//
//@MappedSuperclass
//open class Coding2 : Base() {
//        var system: URI? = null
//        var version: String? = null
//        //        val code:T? = null,
//        var display: String? = null
//        var userSelected: Boolean? = null
//}