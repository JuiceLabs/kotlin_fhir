package com.juicelabs.fhir.model.datatypes

import com.juicelabs.fhir.model.Base
import org.hibernate.annotations.Cascade
import javax.persistence.*

/**
 * https://www.hl7.org/fhir/datatypes.html#Address
 */

@Entity
open  class Address(
        val use: String?,

        val type: String?,

        val text: String?,

        @ElementCollection
        @Cascade(org.hibernate.annotations.CascadeType.ALL)
        val line: List<String>?,

        val city: String?,

        val district: String?,

        val state: String?,

        val postalCode: String?,

        val country: String?,

        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "period_id")
        val period: Period?
) : Base()


