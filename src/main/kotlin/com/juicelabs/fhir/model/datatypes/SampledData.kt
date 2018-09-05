package com.juicelabs.fhir.model.datatypes

import com.juicelabs.fhir.model.Base
import java.math.BigDecimal
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

/**
 * https://www.hl7.org/fhir/datatypes.html#sampleddata
 */
@Entity
open class SampledData(
        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "origin_id")
        val origin: Quantity, // SimpleQuantity

        val period: BigDecimal,

        val factor: BigDecimal?,

        val lowerLimit: BigDecimal?,

        val upperLimit: BigDecimal?,

        val dimensions: Int,

        val data: String

) : Base()