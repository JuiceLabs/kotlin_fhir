package com.juicelabs.fhir.model.subs

import com.juicelabs.fhir.model.Base
import com.juicelabs.fhir.model.datatypes.CodeableConcept
import java.io.Serializable
import javax.persistence.*

@Entity
data class Communication(
        @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinColumn(name = "code_id")
        val language: CodeableConcept,

        val preferred: Boolean
) : Base(), Serializable

