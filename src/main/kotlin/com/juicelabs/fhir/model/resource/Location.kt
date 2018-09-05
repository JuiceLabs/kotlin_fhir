package com.juicelabs.fhir.model.resource

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.Address
import com.juicelabs.fhir.model.datatypes.ContactPoint
import com.juicelabs.fhir.model.datatypes.Identifier
import java.math.BigDecimal
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/location.html
 */
@Entity
open class Location(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "patient_id")
        val identifier: List<Identifier>,

        val status: String?, // todo code

        val opertaionalStatus: String?,

        val name: String?,

        @ElementCollection
        val alias: List<String>,

        val description: String,

        @ElementCollection
        val mode: List<String>, // todo code

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "telecom_id")
        val telecom: List<ContactPoint>,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "address_id")
        val address: Address?,

        val physicalType: String?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "position_id")
        val position: Position

//        val managingOrganization todo ref
//        val partOf todo ref
//        val endpoint todo ref
        )


@Entity
data class Position(
        val longitude: BigDecimal,
        val latitude: BigDecimal,
        val altitude: BigDecimal
): Base()