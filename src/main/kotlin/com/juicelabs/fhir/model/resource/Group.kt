package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.Period
import com.juicelabs.fhir.model.datatypes.Quantity
import com.juicelabs.fhir.model.datatypes.Range
import com.juicelabs.fhir.model.foundation.BackboneElement
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/group.html
 */
@Entity
open class Group(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        val active: Boolean = false,

        val type: String?, // Code todo

        val actual: Boolean = false,

        val code: CodeableConcept?,

        val name: String?,

        val quantity: Int?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val characteristic: List<BackboneElement>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "member_id")
        val member: List<Member>
)

@Entity
data class Characteristic(
        val code: CodeableConcept?,
        val value: Value?,
        val exclude: Boolean = false,
        val period: Period?
) : Base()

@Entity
data class Value(
        val valueCodeableConcept: CodeableConcept?,
        val valueBoolean: Boolean,
        val valueQuantity: Quantity?,
        val valueRange: Range
) : Base()

@Entity
data class Member(
        // todo ref entity
        val period: Period?,
        val inactive: Boolean?
) : Base()