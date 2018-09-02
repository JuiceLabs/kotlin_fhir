package com.juicelabs.fhir.model

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

/**
 * https://www.hl7.org/fhir/datatypes.html#ContactPoint
 */

@Entity
data class ContactPoint(
        val system: String?,
        val value: String?,
        val use: String?,
        val rank: Int?, // postive only

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "period_id")
        val period: Period?
) : Base()