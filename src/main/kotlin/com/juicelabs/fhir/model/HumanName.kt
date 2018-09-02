package com.juicelabs.fhir.model

import javax.persistence.*

/**
 * https://www.hl7.org/fhir/datatypes.html#HumanName
 */

@Entity
data class HumanName(
        val use: String,
        val text: String?,
        var name: String? = null,

        @ElementCollection
        var family: List<String>,  // todo - spec diff?

        @ElementCollection
        var given: List<String>,

        @ElementCollection
        var prefix: List<String>?,

        @ElementCollection
        var suffix: List<String>?,

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "period_id")
        val period: Period?
) : Base()