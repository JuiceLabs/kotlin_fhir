package com.juicelabs.fhir.model.datatypes

import com.juicelabs.fhir.model.Base
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/datatypes.html#ContactPoint
 */

@Entity
data class ContactPoint(
        val system: String?,
        val value: String?,
        val use: String?,
        val rank: Int?, // postive only

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "period_id")
        val period: Period?
) : Base()