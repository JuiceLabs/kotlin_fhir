package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.Identifier
import com.juicelabs.fhir.model.datatypes.Quantity
import com.juicelabs.fhir.model.datatypes.Ratio
import java.time.LocalDateTime
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/substance.html
 */

@Entity
open class Substance(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "identifier_id")
        val identifier: Set<Identifier>,

        val status: String?, // todo code

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "category_id")
        val category: Set<CodeableConcept>,

        val code: CodeableConcept,

        val description: String?,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "instance_id")
        val instance: Set<Instance>,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "ingredient_id")
        val ingredient: Set<Ingredient>
        )


@Entity
data class Instance(
        val identifier: Identifier?,

        val expry: LocalDateTime?,

        val quantity: Quantity? // SimpleQuantity
): Base()

@Entity
data class Ingredient(
        val quantity: Ratio?,

        val substance: SubstanceBB
        ): Base()

@Entity
data class SubstanceBB( // todo better name
        val substanceCodeableConcept: CodeableConcept
//        val substanceReference todo ref
): Base()