package com.juicelabs.fhir.model.resource;

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.CodeableConcept
import com.juicelabs.fhir.model.datatypes.Identifier
import java.time.LocalDateTime
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/devicecomponent.html
 */

@Entity
open class DeviceComponent(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "identifier_id")
        val identifier: Identifier,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "type_id")
        val type: CodeableConcept,

        val lastSystemChange: LocalDateTime?,

//        val source todo ref
//        val parent todo ref

        @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "operation_status_id")
        val operationalStatus: Set<CodeableConcept>,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "parameter_group_id")
        val parameterGroup: CodeableConcept?,

        val measurementPrinciple: String?, //todo code

        @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "production_specification_id")
        val productionSpecification: Set<ProductionSpecification>,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "language_code_id")
        val languageCode: CodeableConcept?
        )


@Entity
data class ProductionSpecification(
        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "spec_type_id")
        val specType: CodeableConcept?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "component_id")
        val componentId: Identifier?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "production_spec_id")
        val productionSpec: CodeableConcept?
): Base()