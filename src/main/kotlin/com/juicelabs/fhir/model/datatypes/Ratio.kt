package com.juicelabs.fhir.model.datatypes

import com.juicelabs.fhir.model.Base
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

/**
 * https://www.hl7.org/fhir/datatypes.html#ratio
 */
@Entity
open class Ratio(
        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "numerator_id")
        val numerator: Quantity?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @JoinColumn(name = "denominator_id")
        val denominator: Quantity?
) : Base()

